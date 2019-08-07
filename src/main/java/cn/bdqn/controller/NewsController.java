package cn.bdqn.controller;

import cn.bdqn.entity.News;
import cn.bdqn.service.news.NewsService;
import cn.bdqn.utils.Page;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewsController {

    @Resource
    private NewsService newsService;

    @RequestMapping("/indexNews")
    @ResponseBody
    public Object indexNews(int currPage,int NewOrGongGao,int ydcs){
        Page pb = new Page();
//        int num = 0;
        pb.setPageSize(4);
        int totalCount = newsService.getCount(NewOrGongGao);
        pb.setTotalCount(totalCount);
        int pageIndex = 1;
        pageIndex = currPage;
        if (pageIndex < 1) {// 当前页码<1时赋值成1
            pageIndex = 1;
        } else if (pageIndex > pb.getTotalPageCount()) {// 当前页码大于总页码数时
            pageIndex = pb.getTotalPageCount();
        }
        pb.setCurrPage(pageIndex-1);
        List<News> newsList = newsService.getNewsList(pb.getCurrPage()*pb.getPageSize(), pb.getPageSize(), NewOrGongGao,ydcs);
        Map<String, Object> map = new HashMap<>();
        map.put("newsList", newsList);
        map.put("pb", pb);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/newslist")
    public String newslist(long id,Model model) {
        News newsXqQuery = newsService.getQueryNewsXq(id);
        long readNum = newsXqQuery.getReadNum()+1;
        newsService.getUpdateReadNum(readNum, id);
        News newsSyp = null;
        if(id>=2){
            newsSyp = newsService.getQueryNewsXq(id-1);
        }
        News newsXyp = newsService.getQueryNewsXq(id+1);
        model.addAttribute("newsXqQuery",newsXqQuery);
        model.addAttribute("newsSyp",newsSyp);
        model.addAttribute("newsXyp",newsXyp);
//        System.out.println("-------"+newsXqQuery.getTitle());
        return "newsList";
    }

    @RequestMapping("/news")
    public String news(int NewOrGongGao, Model model) {
        model.addAttribute("NewOrGongGao",NewOrGongGao);
        return "news";
    }
}

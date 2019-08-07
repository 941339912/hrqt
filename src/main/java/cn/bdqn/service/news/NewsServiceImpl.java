package cn.bdqn.service.news;

import cn.bdqn.dao.NewsMapper;
import cn.bdqn.entity.News;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    @Override
    public List<News> getNewsList(int currPage, int pageSize, int NewOrGongGao, int ydcs) {
        return newsMapper.findNewsList(currPage, pageSize, NewOrGongGao,ydcs);
    }

    @Override
    public int getCount(int newOrGg) {
        return newsMapper.findCount(newOrGg);
    }

    @Override
    public int getUpdateReadNum(long readNum,long id) {
        return newsMapper.findUpdateReadNum(readNum, id);
    }

    @Override
    public News getQueryNewsXq(long id) {
        return newsMapper.findQueryNewsXq(id);
    }


}

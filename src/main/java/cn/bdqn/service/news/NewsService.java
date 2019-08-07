package cn.bdqn.service.news;

import cn.bdqn.entity.News;

import java.util.List;

public interface NewsService {
    /**
     * 查询所有数据，分页
     * @return
     */
    public List<News> getNewsList(int currPage, int pageSize, int NewOrGongGao, int ydcs);

    /**
     * 查询总记录数
     */
    public int getCount(int newOrGg);

    /**
     * 更新阅读次数
     * @param
     * @return
     */
    public int getUpdateReadNum(long readNum, long id);


    /**
     * 查询新闻和公告详情
     * @return
     */
    public News getQueryNewsXq(long id);
}

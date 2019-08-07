package cn.bdqn.dao;

import cn.bdqn.entity.News;

import java.util.List;

public interface NewsMapper {
    /**
     * 查询所有数据，分页
     * @return
     */
    public List<News> findNewsList(int currPage, int pageSize, int NewOrGongGao, int ydcs);

    /**
     * 查询总记录数
     */
    public int findCount(int newOrGg);

    /**
     * 更新阅读次数
     * @param
     * @return
     */
    public int findUpdateReadNum(long readNum, long id);

    /**
     * 查询新闻和公告详情
     * @return
     */
    public News findQueryNewsXq(long id);
}

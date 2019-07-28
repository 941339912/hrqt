package cn.bdqn.dao;

import cn.bdqn.entity.Koffice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KofficeMapper {

    /**
     * 获取重点科室
     * @return
     */
    public List<Koffice> findEmphasisList();

    /**
     * 根据id获取科室信息
     * @param kId
     * @return
     */
    public Koffice findKofficeById(@Param("kId") Integer kId);

    /**
     * 获取所有科室
     * @return
     */
    public List<Koffice> findOfficeList();
}

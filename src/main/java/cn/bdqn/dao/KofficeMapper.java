package cn.bdqn.dao;

import cn.bdqn.entity.Koffice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 科室导航
 */
@Repository
public interface KofficeMapper {

    /**
     * 根据医学部id查询科室
     * @return
     */
    List<Koffice> selectKoffices(@Param("medicalId") Long medicalId);

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

package cn.bdqn.service.koffice;

import cn.bdqn.entity.Koffice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KofficeService {

    /**
     * 查询科室
     * @return
     */
    public List<Koffice> findEmphasisList();

    /**
     * 根据id获取科室信息
     * @param kId
     * @return
     */
    public Koffice findKofficeById(Integer kId);

    /**
     * 获取所有科室
     * @return
     */
    public List<Koffice> findOfficeList();

    /**
     * 根据医学部id查询科室
     * @return
     */
    List<Koffice> selectKoffices(@Param("medicalId") Long medicalId);
}

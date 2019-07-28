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
}

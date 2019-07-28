package cn.bdqn.service.koffice;

import cn.bdqn.entity.Medical;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicalService {

    /**
     * 查询所有部门
     * @return
     */
    public List<Medical> findMedicalList();

    /**
     * 查询所有医学部
     * @return
     */
    List<Medical> selectMedicals(@Param("id")Long id);
}

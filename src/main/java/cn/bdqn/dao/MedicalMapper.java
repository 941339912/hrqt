package cn.bdqn.dao;

import cn.bdqn.entity.Medical;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 医学部
 */
@Repository
public interface MedicalMapper {
    /**
     * 查询所有医学部
     * @return
     */
    List<Medical> selectMedicals(@Param("id")Long id);

    /**
     * 查询所有部门
     * @return
     */
    public List<Medical> findMedicalList();
}

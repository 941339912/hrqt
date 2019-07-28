package cn.bdqn.dao;

import cn.bdqn.entity.Medical;

import java.util.List;

public interface MedicalMapper {

    /**
     * 查询所有部门
     * @return
     */
    public List<Medical> findMedicalList();
}

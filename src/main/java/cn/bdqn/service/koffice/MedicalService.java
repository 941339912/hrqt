package cn.bdqn.service.koffice;

import cn.bdqn.entity.Medical;

import java.util.List;

public interface MedicalService {

    /**
     * 查询所有部门
     * @return
     */
    public List<Medical> findMedicalList();
}

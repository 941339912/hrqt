package cn.bdqn.dao;

import cn.bdqn.entity.Doctor;

import java.util.List;

public interface DoctorMapper {

    /**
     * 查询所有医生，模糊查询，拼音查询
     *
     * @return
     */
    public List<Doctor> findQueryDoctor(String dname, String dpinyin);

    public int add();
}

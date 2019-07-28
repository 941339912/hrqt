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

    /**
     * 根据id查询医生
     * @param did
     * @return
     */
    public Doctor findByIdDoctor(int did);

    /**
     *  查询科室医生
     * @param kId
     * @return
     */
    public List<Doctor> findListByKId(Integer kId);

}

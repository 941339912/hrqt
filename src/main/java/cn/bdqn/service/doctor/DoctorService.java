package cn.bdqn.service.doctor;

import cn.bdqn.entity.Doctor;

import java.util.List;

public interface DoctorService {
    /**
     * 查询所有医生，模糊查询，拼音查询
     *
     * @return
     */
    public List<Doctor> getQueryDoctor(String dname, String dpinyin);

    /**
     * 根据id查询医生
     * @param did
     * @return
     */
    public Doctor getByIdDoctor(int did);

    /**
     * 根据科室查询医生
     * @param kId
     * @return
     */
    public List<Doctor> findListByKId(Integer kId);
}

package cn.bdqn.service.doctor;

import cn.bdqn.dao.DoctorMapper;
import cn.bdqn.entity.Doctor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> getQueryDoctor(String dname, String dpinyin) {
        return doctorMapper.findQueryDoctor(dname, dpinyin);
    }

    @Override
    public int add() {
        return 0;
    }
}

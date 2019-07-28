package cn.bdqn.service.koffice;

import cn.bdqn.dao.MedicalMapper;
import cn.bdqn.entity.Medical;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService {

    @Resource
    private MedicalMapper medicalMapper;

    @Override
    public List<Medical> findMedicalList() {
        return medicalMapper.findMedicalList();
    }
}

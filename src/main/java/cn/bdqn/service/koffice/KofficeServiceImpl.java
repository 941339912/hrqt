package cn.bdqn.service.koffice;

import cn.bdqn.dao.KofficeMapper;
import cn.bdqn.entity.Koffice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("kOfficeService")
public class KofficeServiceImpl implements KofficeService {

    @Resource
    private KofficeMapper kofficeMapper;

    @Override
    public List<Koffice> findEmphasisList() {
        return kofficeMapper.findEmphasisList();
    }

    @Override
    public Koffice findKofficeById(Integer kId) {
        return kofficeMapper.findKofficeById(kId);
    }

    @Override
    public List<Koffice> findOfficeList() {
        return kofficeMapper.findOfficeList();
    }

    @Override
    public List<Koffice> selectKoffices(Long medicalId) {
        return kofficeMapper.selectKoffices(medicalId);
    }

}

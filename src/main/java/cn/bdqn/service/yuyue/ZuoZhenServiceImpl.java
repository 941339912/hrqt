package cn.bdqn.service.yuyue;

import cn.bdqn.dao.ZuoZhenMapper;
import cn.bdqn.entity.ZuoZhen;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ZuoZhenServiceImpl implements ZuoZhenService {

    @Resource
    private ZuoZhenMapper zuoZhenMapper;

    @Override
    public ZuoZhen getZuoZhenBydId(Integer dId) {
        return zuoZhenMapper.getZuoZhenBydId(dId);
    }
}

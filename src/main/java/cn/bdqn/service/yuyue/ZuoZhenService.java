package cn.bdqn.service.yuyue;

import cn.bdqn.entity.ZuoZhen;

public interface ZuoZhenService {

    /**
     * 根据医生外键获取坐诊信息
     * @param dId
     * @return
     */
    public ZuoZhen getZuoZhenBydId(Integer dId);
}

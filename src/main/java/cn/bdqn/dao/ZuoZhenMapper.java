package cn.bdqn.dao;

import cn.bdqn.entity.ZuoZhen;

public interface ZuoZhenMapper {

    /**
     * 根据医生外键获取坐诊信息
     * @param dId
     * @return
     */
    public ZuoZhen getZuoZhenBydId(Integer dId);
}

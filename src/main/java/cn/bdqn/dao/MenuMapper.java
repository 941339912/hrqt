package cn.bdqn.dao;

import cn.bdqn.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

    /**
     * 获取一级菜单列表
     * @return
     */
    public List<Menu> findMenuList(@Param("isqianhou") Integer isqianhou);

    /**
     * 获取二级菜单列表
     * @param isqianhou
     * @return
     */
    public List<Menu> findTwoMenuList(@Param("isqianhou") Integer isqianhou);
}

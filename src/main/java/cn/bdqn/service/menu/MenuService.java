package cn.bdqn.service.menu;

import cn.bdqn.entity.Menu;

import java.util.List;

public interface MenuService {

    /**
     * 获取一级菜单列表
     * @return
     */
    public List<Menu> getMenuList(Integer isqianhou);

    /**
     * 获取二级菜单列表
     * @return
     */
    public List<Menu> getTwoMenuList(Integer isqianhou);
}

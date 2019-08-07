package cn.bdqn.service.menu;

import cn.bdqn.dao.MenuMapper;
import cn.bdqn.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuList(Integer isqianhou) {
        return menuMapper.findMenuList(isqianhou);
    }

    @Override
    public List<Menu> getTwoMenuList(Integer isqianhou) {
        return menuMapper.findTwoMenuList(isqianhou);
    }
}

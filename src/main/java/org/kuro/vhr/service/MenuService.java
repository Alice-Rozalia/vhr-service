package org.kuro.vhr.service;

import org.kuro.vhr.model.entity.Menu;
import org.kuro.vhr.model.response.Result;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/25 16:32
 */
public interface MenuService {

    List<Menu> getMenusByHrId();

    List<Menu> getAllMenusWithRole();

    Result getAllMenus();

    Result getMenusByRid(Integer rid);

    Result getMidsByRid(Integer rid);

    /**
     * 分配权限
     * @param rid       角色id
     * @param mids      菜单id（数组）
     * @return
     */
    Result updateMenuRole(Integer rid, Integer[] mids);
}

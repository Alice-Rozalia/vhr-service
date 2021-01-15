package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.MenuMapper;
import org.kuro.vhr.mapper.MenuRoleMapper;
import org.kuro.vhr.model.entity.Hr;
import org.kuro.vhr.model.entity.Menu;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.kuro.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/25 16:34
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    // @Cacheable
    @Override
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    @Override
    public Result getAllMenus() {
        List<Menu> menus = menuMapper.getAllMenus();
        return Result.ok().data("menus", menus);
    }

    @Override
    public Result getMenusByRid(Integer rid) {
        List<Menu> menus = menuMapper.getMenusByRid(rid);
        return Result.ok().data("menus", menus);
    }

    @Override
    public Result getMidsByRid(Integer rid) {
        List<Integer> mids = menuMapper.getMidsByRid(rid);
        return Result.ok().data("mids", mids);
    }

    /**
     * 分配权限
     * @param rid  角色id
     * @param mids 菜单id（数组）
     * @return
     */
    @Transactional
    @Override
    public Result updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        if (result == mids.length) {
            return Result.ok(ResultCode.UPDATE_SUCCESS);
        }
        return Result.error(ResultCode.UPDATE_ERROR);
    }

}

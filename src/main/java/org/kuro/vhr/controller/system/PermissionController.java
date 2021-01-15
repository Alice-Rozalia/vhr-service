package org.kuro.vhr.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kuro.vhr.model.entity.Role;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.MenuService;
import org.kuro.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Kuro
 * @Date: 2020/12/27 22:44
 */
@RestController
@RequestMapping("/system/basic/permission")
@Api(value = "系统管理模块", tags = "权限管理")
public class PermissionController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/roles")
    @ApiOperation(value = "角色列表", notes = "获取所有的角色")
    public Result getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    @ApiOperation(value = "操作菜单", notes = "获取所有的菜单")
    public Result getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/menus/{rid}")
    @ApiOperation(value = "角色权限", notes = "根据角色id获取该角色可操作的菜单")
    public Result getMenusByRid(@PathVariable Integer rid) {
        return menuService.getMenusByRid(rid);
    }

    @GetMapping("/mids/{rid}")
    @ApiOperation(value = "选中菜单", notes = "根据角色id获取被选中的菜单id")
    public Result getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/assign")
    @ApiOperation(value = "分配权限", notes = "分配权限")
    public Result updateMenuRole(Integer rid, Integer[] mids) {
        return menuService.updateMenuRole(rid, mids);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加角色", notes = "添加角色")
    public Result addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @DeleteMapping("/delete/{rid}")
    @ApiOperation(value = "删除角色", notes = "根据id删除角色")
    public Result deleteRoleById(@PathVariable Integer rid) {
        return roleService.deleteRoleById(rid);
    }
}

package org.kuro.vhr.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kuro.vhr.model.entity.Hr;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.HrService;
import org.kuro.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2021/1/10 12:35
 */
@RestController
@RequestMapping("/system/basic/hr")
@Api(value = "系统管理模块", tags = "操作员管理")
public class HrController {

    @Autowired
    private HrService hrService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    @ApiOperation(value = "用户列表", notes = "获取除登录用户外的用户")
    public Result getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/status")
    @ApiOperation(value = "修改状态", notes = "修改用户的状态为启用或禁用")
    public Result updateHrStatus(@RequestBody Hr hr) {
        return hrService.updateHrStatus(hr);
    }

    @GetMapping("/roles")
    @ApiOperation(value = "全部角色", notes = "获取所有的角色")
    public Result getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/update_roles")
    @ApiOperation(value = "修改用户角色", notes = "根据用户id，修改用户的角色")
    public Result updateHrRole(Integer hrid, Integer[] rids) {
        return hrService.updateHrRole(hrid, rids);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteHrById(@PathVariable Integer id) {
        return hrService.deleteHrById(id);
    }
}

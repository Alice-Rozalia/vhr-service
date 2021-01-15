package org.kuro.vhr.controller.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kuro.vhr.model.entity.Menu;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/25 16:31
 */
@RestController
@RequestMapping("/system/config")
@Api(value = "系统管理模块", tags = "系统管理")
public class SystemConfigController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    @ApiOperation(value = "获取菜单", notes = "根据登录用户的id获取菜单")
    public Result getMenusByHrId() {
        List<Menu> menus = menuService.getMenusByHrId();
        return Result.ok().data("menus", menus);
    }

}

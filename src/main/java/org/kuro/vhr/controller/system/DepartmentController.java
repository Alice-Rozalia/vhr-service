package org.kuro.vhr.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Kuro
 * @Date: 2020/12/29 17:18
 */
@RestController
@RequestMapping("/system/basic/department")
@Api(value = "系统管理模块", tags = "部门管理")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    @ApiOperation(value = "部门列表", notes = "获取所有的部门")
    public Result getAllDepartments() {
        return departmentService.getAllDepartments();
    }

}

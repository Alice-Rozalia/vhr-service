package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.DepartmentMapper;
import org.kuro.vhr.model.entity.Department;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/29 17:23
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Result getAllDepartments() {
        List<Department> departments = departmentMapper.getAllDepartmentsByParentId(-1);
        return Result.ok().data("departments", departments);
    }
}

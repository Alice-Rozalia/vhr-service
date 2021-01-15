package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.EmployeeMapper;
import org.kuro.vhr.model.entity.Employee;
import org.kuro.vhr.model.page.PageResult;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.kuro.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2021/1/14 14:40
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageResult<Employee> getEmployeeByPage(Integer page, Integer limit, String key) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        }
        List<Employee> employee = employeeMapper.getEmployeeByPage(page, limit, key);
        Long total = employeeMapper.getTotal(key);
        PageResult<Employee> pageResult = new PageResult<>();
        pageResult.setItems(employee);
        pageResult.setTotal(total);
        return pageResult;
    }

    @Override
    public Result addEmp(Employee employee) {
        if (employeeMapper.insertSelective(employee) == 1) {
            return Result.ok(ResultCode.ADD_SUCCESS);
        }
        return Result.ok(ResultCode.ADD_ERROR);
    }
}

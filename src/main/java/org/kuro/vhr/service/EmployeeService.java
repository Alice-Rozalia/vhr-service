package org.kuro.vhr.service;

import org.kuro.vhr.model.entity.Employee;
import org.kuro.vhr.model.page.PageResult;
import org.kuro.vhr.model.response.Result;

/**
 * @Author: Kuro
 * @Date: 2021/1/14 14:40
 */
public interface EmployeeService {

    PageResult<Employee> getEmployeeByPage(Integer page, Integer limit, String key);

    Result addEmp(Employee employee);

    Integer maxWorkId();

    Result deleteEmpById(Integer id);
}

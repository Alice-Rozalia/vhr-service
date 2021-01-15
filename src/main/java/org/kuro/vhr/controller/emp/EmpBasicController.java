package org.kuro.vhr.controller.emp;

import org.kuro.vhr.model.entity.Employee;
import org.kuro.vhr.model.page.PageResult;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Kuro
 * @Date: 2021/1/14 14:35
 */
@RestController
@RequestMapping("/emp/basic")
public class EmpBasicController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public Result getEmployeeByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "key", required = false) String key
    ) {
        PageResult<Employee> employee = employeeService.getEmployeeByPage(page, limit, key);
        return Result.ok().data("employee", employee);
    }

    @PostMapping("/add")
    public Result addEmp(@RequestBody Employee employee) {
        return employeeService.addEmp(employee);
    }
}

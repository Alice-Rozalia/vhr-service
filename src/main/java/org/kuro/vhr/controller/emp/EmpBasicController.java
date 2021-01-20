package org.kuro.vhr.controller.emp;

import org.kuro.vhr.model.entity.Employee;
import org.kuro.vhr.model.entity.Nation;
import org.kuro.vhr.model.entity.Politicsstatus;
import org.kuro.vhr.model.page.PageResult;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.EmployeeService;
import org.kuro.vhr.service.NationService;
import org.kuro.vhr.service.PoliticsstatusService;
import org.kuro.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2021/1/14 14:35
 */
@RestController
@RequestMapping("/emp/basic")
public class EmpBasicController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private NationService nationService;

    @Autowired
    private PoliticsstatusService politicsstatusService;

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

    @DeleteMapping("/delete/{id}")
    public Result deleteEmpById(@PathVariable Integer id) {
        return employeeService.deleteEmpById(id);
    }

    @GetMapping("/nations")
    public Result getAllNations() {
        List<Nation> nations = nationService.getAllNations();
        return Result.ok().data("nations", nations);
    }

    @GetMapping("/politicsstatus")
    public Result getAllPoliticsstatus() {
        List<Politicsstatus> list = politicsstatusService.getAllPoliticsstatus();
        return Result.ok().data("list", list);
    }

    @GetMapping("/max_work_id")
    public Result maxWorkId() {
        return Result.ok().data("max_work_id", String.format("%08d", employeeService.maxWorkId() + 1));
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list = employeeService.getEmployeeByPage(null, null, null).getItems();
        return POIUtils.employeeToExcel(list);
    }
}

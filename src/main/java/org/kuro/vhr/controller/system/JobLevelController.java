package org.kuro.vhr.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kuro.vhr.model.entity.JobLevel;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/27 16:21
 */
@RestController
@RequestMapping("/system/basic/level")
@Api(value = "系统管理模块", tags = "职称管理")
public class JobLevelController {

    @Autowired
    private JobLevelService jobLevelService;

    @GetMapping("/jobs")
    @ApiOperation(value = "职称列表", notes = "获取所有的职称")
    public Result getAllJobLevels() {
        List<JobLevel> levels = jobLevelService.getAllJobLevels();
        return Result.ok().data("job_level", levels);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加职称", notes = "添加职称")
    public Result addJobLevel(@RequestBody JobLevel jobLevel) {
        return jobLevelService.addJobLevel(jobLevel);
    }

    @PutMapping("/edit")
    @ApiOperation(value = "修改职称", notes = "修改职称")
    public Result updateJobLevel(@RequestBody JobLevel jobLevel) {
        return jobLevelService.updateJobLevel(jobLevel);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除职称", notes = "根据id删除职称")
    public Result deleteJobLevelById(@PathVariable Integer id) {
        return jobLevelService.deleteJobLevelById(id);
    }

    @DeleteMapping("/many")
    @ApiOperation(value = "批量删除", notes = "批量删除职称")
    public Result bulkDelete(Integer[] ids) {
        return jobLevelService.bulkDelete(ids);
    }
}

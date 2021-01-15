package org.kuro.vhr.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kuro.vhr.model.entity.Position;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/26 16:45
 */
@RestController
@RequestMapping("/system/basic/position")
@Api(value = "系统管理模块", tags = "职位管理")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/list")
    @ApiOperation(value = "获取职位列表", notes = "获取所有的职位")
    public Result getAllPositions() {
        List<Position> list = positionService.getAllPositions();
        return Result.ok().data("positions", list);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加职位", notes = "添加职位")
    public Result addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @PutMapping("/edit")
    @ApiOperation(value = "修改职位", notes = "修改职位")
    public Result updatePosition(@RequestBody Position position) {
        return positionService.updatePosition(position);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除职位", notes = "删除职位")
    public Result deletePositionById(@PathVariable Integer id) {
        return positionService.deletePositionById(id);
    }

    @DeleteMapping("/many")
    @ApiOperation(value = "批量删除", notes = "批量删除职位")
    public Result bulkDelete(Integer[] ids) {
        return positionService.bulkDelete(ids);
    }
}

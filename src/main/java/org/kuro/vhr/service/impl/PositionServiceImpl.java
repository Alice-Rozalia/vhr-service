package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.PositionMapper;
import org.kuro.vhr.model.entity.Position;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.kuro.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/26 16:49
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    /**
     * 查询所有职位
     * @return
     */
    @Override
    public List<Position> getAllPositions() {
        return positionMapper.selectAll();
    }

    /**
     * 添加职位
     * @param position
     * @return
     */
    @Override
    public Result addPosition(Position position) {
        if (position == null) {
            return Result.error(ResultCode.PARAM_IS_BLANK);
        }
        position.setEnabled(true);
        position.setCreateDate(new Date());
        if (positionMapper.insertSelective(position) == 1) {
            return Result.ok(ResultCode.ADD_SUCCESS);
        }
        return Result.error(ResultCode.ADD_ERROR);
    }

    /**
     * 更新职位信息
     * @param position
     * @return
     */
    @Transactional
    @Override
    public Result updatePosition(Position position) {
        if (position.getId() == null) {
            return Result.error(ResultCode.PARAM_NOT_COMPLETE);
        }
        if (positionMapper.updateByPrimaryKeySelective(position) == 1) {
            return Result.ok(ResultCode.UPDATE_SUCCESS);
        }
        return Result.error(ResultCode.UPDATE_ERROR);
    }

    /**
     * 根据id删除职位
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Result deletePositionById(Integer id) {
        if (id == null) {
            return Result.error(ResultCode.PARAM_IS_BLANK);
        }
        if (positionMapper.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCode.DELETE_SUCCESS);
        }
        return Result.error(ResultCode.DELETE_ERROR);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public Result bulkDelete(Integer[] ids) {
        if (ids == null || ids.length <= 0) {
            return Result.error(ResultCode.PARAM_IS_BLANK);
        }
        if (positionMapper.bulkDelete(ids) == ids.length) {
            return Result.ok(ResultCode.DELETE_SUCCESS);
        }
        return Result.error(ResultCode.DELETE_ERROR);
    }

}

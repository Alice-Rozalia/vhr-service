package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.HrMapper;
import org.kuro.vhr.mapper.HrRoleMapper;
import org.kuro.vhr.model.entity.Hr;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.kuro.vhr.service.HrService;
import org.kuro.vhr.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2021/1/10 12:39
 */
@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrMapper hrMapper;

    @Autowired
    private HrRoleMapper hrRoleMapper;

    @Override
    public Result getAllHrs(String keywords) {
        List<Hr> list = hrMapper.getAllHrs(CurrentUser.getCurrentHr().getId(), keywords);
        return Result.ok().data("hrs", list);
    }

    @Override
    public Result updateHrStatus(Hr hr) {
        if (hrMapper.updateByPrimaryKeySelective(hr) == 1) {
            return Result.ok(ResultCode.UPDATE_SUCCESS);
        }
        return Result.error(ResultCode.UPDATE_ERROR);
    }

    @Transactional
    @Override
    public Result updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        if (hrRoleMapper.addRole(hrid, rids) == rids.length) {
            return Result.ok(ResultCode.UPDATE_SUCCESS);
        }
        return Result.error(ResultCode.UPDATE_ERROR);
    }

    @Override
    public Result deleteHrById(Integer id) {
        if (hrMapper.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCode.DELETE_SUCCESS);
        }
        return Result.ok(ResultCode.DELETE_ERROR);
    }
}

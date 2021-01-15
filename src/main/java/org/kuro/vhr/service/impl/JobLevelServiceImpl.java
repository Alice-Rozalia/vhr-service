package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.JobLevelMapper;
import org.kuro.vhr.model.entity.JobLevel;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.kuro.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/27 16:24
 */
@Service
public class JobLevelServiceImpl implements JobLevelService {

    @Autowired
    private JobLevelMapper jobLevelMapper;

    /**
     * 获取所有的职称
     * @return
     */
    @Override
    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.selectAll();
    }

    /**
     * 添加职称
     * @param jobLevel
     * @return
     */
    @Override
    public Result addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        if (jobLevelMapper.insertSelective(jobLevel) == 1) {
            return Result.ok(ResultCode.ADD_SUCCESS);
        }
        return Result.error(ResultCode.ADD_ERROR);
    }

    /**
     * 更新职称信息
     * @param jobLevel
     * @return
     */
    @Override
    public Result updateJobLevel(JobLevel jobLevel) {
        if (jobLevel.getId() == null) {
            return Result.error(ResultCode.PARAM_NOT_COMPLETE);
        }
        if (jobLevelMapper.updateByPrimaryKeySelective(jobLevel) == 1) {
            return Result.ok(ResultCode.UPDATE_SUCCESS);
        }
        return Result.error(ResultCode.UPDATE_ERROR);
    }

    /**
     * 根据id删除职称
     * @param id
     * @return
     */
    @Override
    public Result deleteJobLevelById(Integer id) {
        if (id == null) {
            return Result.error(ResultCode.PARAM_IS_BLANK);
        }
        if (jobLevelMapper.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCode.DELETE_SUCCESS);
        }
        return Result.error(ResultCode.DELETE_ERROR);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public Result bulkDelete(Integer[] ids) {
        if (ids == null || ids.length <= 0) {
            return Result.error(ResultCode.PARAM_IS_BLANK);
        }
        if (jobLevelMapper.bulkDelete(ids) == ids.length) {
            return Result.ok(ResultCode.DELETE_SUCCESS);
        }
        return Result.error(ResultCode.DELETE_ERROR);
    }
}

package org.kuro.vhr.service;

import org.kuro.vhr.model.entity.JobLevel;
import org.kuro.vhr.model.response.Result;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/27 16:23
 */
public interface JobLevelService {

    /**
     * 获取所有的职称
     * @return
     */
    List<JobLevel> getAllJobLevels();

    /**
     * 添加职称
     * @param jobLevel
     * @return
     */
    Result addJobLevel(JobLevel jobLevel);

    /**
     * 更新职称信息
     * @param jobLevel
     * @return
     */
    Result updateJobLevel(JobLevel jobLevel);

    /**
     * 根据id删除职称
     * @param id
     * @return
     */
    Result deleteJobLevelById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Result bulkDelete(Integer[] ids);
}

package org.kuro.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.vhr.model.entity.JobLevel;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:58
 */
public interface JobLevelMapper extends Mapper<JobLevel> {

    Integer bulkDelete(@Param("ids") Integer[] ids);

}

package org.kuro.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.vhr.model.entity.Department;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:56
 */
public interface DepartmentMapper extends Mapper<Department> {

    List<Department> getAllDepartmentsByParentId(@Param("pid") Integer pid);

}

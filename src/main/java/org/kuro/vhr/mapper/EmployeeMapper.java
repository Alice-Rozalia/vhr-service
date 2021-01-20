package org.kuro.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.vhr.model.entity.Employee;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:57
 */
public interface EmployeeMapper extends Mapper<Employee> {

    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("limit") Integer limit, @Param("key") String key);

    Long getTotal(@Param("key") String key);

    Integer maxWorkId();
}

package org.kuro.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.vhr.model.entity.HrRole;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: Kuro
 * @Date: 2021/1/11 14:28
 */
public interface HrRoleMapper extends Mapper<HrRole> {
    void deleteByHrid(Integer hrid);

    int addRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}

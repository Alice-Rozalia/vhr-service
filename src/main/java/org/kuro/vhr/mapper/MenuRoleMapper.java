package org.kuro.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.vhr.model.entity.MenuRole;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: Kuro
 * @Date: 2020/12/29 16:13
 */
public interface MenuRoleMapper extends Mapper<MenuRole> {

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);

    void deleteByRid(@Param("rid") Integer rid);
}

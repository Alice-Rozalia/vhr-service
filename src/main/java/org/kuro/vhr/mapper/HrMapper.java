package org.kuro.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.vhr.model.entity.Hr;
import org.kuro.vhr.model.entity.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:58
 */
public interface HrMapper extends Mapper<Hr> {

    Hr loadUserByUsername(@Param("username") String username);

    List<Role> getHrRolesById(@Param("id") Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

    int updateByPrimaryKeySelective(Hr record);
}

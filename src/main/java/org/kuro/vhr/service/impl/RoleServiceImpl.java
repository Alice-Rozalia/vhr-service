package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.RoleMapper;
import org.kuro.vhr.model.entity.Role;
import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.kuro.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/27 22:47
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Result getAllRoles() {
        List<Role> roles = roleMapper.selectAll();
        return Result.ok().data("roles", roles);
    }

    @Override
    public Result addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        if (roleMapper.insertSelective(role) == 1) {
            return Result.ok(ResultCode.ADD_SUCCESS);
        }
        return Result.ok(ResultCode.ADD_ERROR);
    }

    @Override
    public Result deleteRoleById(Integer rid) {
        if (roleMapper.deleteByPrimaryKey(rid) == 1) {
            return Result.ok(ResultCode.DELETE_SUCCESS);
        }
        return Result.ok(ResultCode.DELETE_ERROR);
    }
}

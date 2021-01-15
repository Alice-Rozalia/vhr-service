package org.kuro.vhr.service;

import org.kuro.vhr.model.entity.Role;
import org.kuro.vhr.model.response.Result;

/**
 * @Author: Kuro
 * @Date: 2020/12/27 22:46
 */
public interface RoleService {

    Result getAllRoles();

    Result addRole(Role role);

    Result deleteRoleById(Integer rid);
}

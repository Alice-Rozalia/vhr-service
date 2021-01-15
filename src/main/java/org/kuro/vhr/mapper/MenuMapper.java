package org.kuro.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.vhr.model.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:59
 */
public interface MenuMapper extends Mapper<Menu> {

    List<Menu> getMenusByHrId(@Param("hrid") Integer hrid);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Menu> getMenusByRid(@Param("rid") Integer rid);

    List<Integer> getMidsByRid(@Param("rid") Integer rid);
}

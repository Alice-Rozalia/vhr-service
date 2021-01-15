package org.kuro.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.vhr.model.entity.Position;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: Kuro
 * @Date: 2020/12/26 16:50
 */
public interface PositionMapper extends Mapper<Position> {

    Integer bulkDelete(@Param("ids") Integer[] ids);

}

package org.kuro.vhr.service;

import org.kuro.vhr.model.entity.Position;
import org.kuro.vhr.model.response.Result;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/26 16:48
 */
public interface PositionService {

    /**
     * 查询所有职位
     * @return
     */
    List<Position> getAllPositions();

    /**
     * 添加职位
     * @param position
     * @return
     */
    Result addPosition(Position position);

    /**
     * 更新职位信息
     * @param position
     * @return
     */
    Result updatePosition(Position position);

    /**
     * 根据id删除职位
     * @param id
     * @return
     */
    Result deletePositionById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Result bulkDelete(Integer[] ids);
}

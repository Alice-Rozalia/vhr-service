package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.NationMapper;
import org.kuro.vhr.model.entity.Nation;
import org.kuro.vhr.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2021/1/18 11:54
 */
@Service
public class NationServiceImpl implements NationService {

    @Autowired
    private NationMapper nationMapper;

    @Override
    public List<Nation> getAllNations() {
        return nationMapper.selectAll();
    }
}

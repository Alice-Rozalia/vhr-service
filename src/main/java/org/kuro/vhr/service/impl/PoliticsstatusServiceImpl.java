package org.kuro.vhr.service.impl;

import org.kuro.vhr.mapper.PoliticsstatusMapper;
import org.kuro.vhr.model.entity.Politicsstatus;
import org.kuro.vhr.service.PoliticsstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2021/1/18 12:00
 */
@Service
public class PoliticsstatusServiceImpl implements PoliticsstatusService {

    @Autowired
    private PoliticsstatusMapper politicsstatusMapper;

    @Override
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.selectAll();
    }
}

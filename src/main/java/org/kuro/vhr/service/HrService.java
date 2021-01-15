package org.kuro.vhr.service;

import org.kuro.vhr.model.entity.Hr;
import org.kuro.vhr.model.response.Result;

/**
 * @Author: Kuro
 * @Date: 2021/1/10 12:39
 */
public interface HrService {

    Result getAllHrs(String keywords);

    Result updateHrStatus(Hr hr);

    Result updateHrRole(Integer hrid, Integer[] rids);

    Result deleteHrById(Integer id);
}

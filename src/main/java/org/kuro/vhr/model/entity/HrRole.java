package org.kuro.vhr.model.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:49
 */
@Data
public class HrRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer hrid;

    private Integer rid;
}

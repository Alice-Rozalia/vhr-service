package org.kuro.vhr.model.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:51
 */
@Data
public class MenuRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer mid;

    private Integer rid;
}

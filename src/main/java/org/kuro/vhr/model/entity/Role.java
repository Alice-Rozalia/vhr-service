package org.kuro.vhr.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:43
 */
@Data
@ApiModel(value="Role对象", description="角色表")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "角色标识")
    private String name;

    @ApiModelProperty(value = "角色名称")
    private String nameZh;
}

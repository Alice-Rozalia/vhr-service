package org.kuro.vhr.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:48
 */
@Data
@ApiModel(value="Department对象", description="部门表")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "部门名称")
    private String name;

    private Integer parentId;

    @ApiModelProperty(value = "路径")
    private String depPath;

    @ApiModelProperty(value = "是否可用")
    private Boolean enabled;

    private Boolean isParent;

    private List<Department> children = new ArrayList<>();
}

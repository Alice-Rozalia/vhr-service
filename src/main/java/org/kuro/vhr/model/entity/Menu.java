package org.kuro.vhr.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:50
 */
@Data
@ApiModel(value="Menu对象", description="菜单表")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "API请求路径")
    private String url;

    @ApiModelProperty(value = "前端路由路径")
    private String path;

    @ApiModelProperty(value = "组件名称")
    private String component;

    @ApiModelProperty(value = "组件中文名")
    private String name;

    @ApiModelProperty(value = "菜单图标")
    private String iconCls;

    private Meta meta;

    private Integer parentId;

    @ApiModelProperty(value = "是否可用")
    private Boolean enabled;

    @ApiModelProperty(value = "子菜单")
    private List<Menu> children;

    private List<Role> roles;
}

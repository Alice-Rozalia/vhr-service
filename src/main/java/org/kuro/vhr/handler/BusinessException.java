package org.kuro.vhr.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Kuro
 * @Date: 2020/12/27 9:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "错误信息")
    private String errMsg;

}

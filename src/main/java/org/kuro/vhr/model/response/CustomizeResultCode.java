package org.kuro.vhr.model.response;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 15:36
 */
public interface CustomizeResultCode {

    /**
     * 获取错误状态码
     * @return 错误状态码
     */
    Integer getCode();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    String getMessage();
}

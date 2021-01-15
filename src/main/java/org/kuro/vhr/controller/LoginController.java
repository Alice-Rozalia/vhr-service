package org.kuro.vhr.controller;

import org.kuro.vhr.model.response.Result;
import org.kuro.vhr.model.response.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Kuro
 * @Date: 2020/12/23 19:01
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public Result login() {
        return Result.error(ResultCode.USER_NOT_LOGIN);
    }

}

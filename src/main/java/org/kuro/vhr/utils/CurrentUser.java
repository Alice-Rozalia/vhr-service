package org.kuro.vhr.utils;

import org.kuro.vhr.model.entity.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: Kuro
 * @Date: 2021/1/10 12:42
 */
public class CurrentUser {

    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}

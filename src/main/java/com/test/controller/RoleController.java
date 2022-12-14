package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author herixin
 * @create 2022-12-13 21:53
 */
@Controller
public class RoleController {
    @RequestMapping("/aa")
    public String update() {
        return "unauthorized";
    }
}

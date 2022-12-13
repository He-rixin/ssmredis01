package com.test.controller;

import com.test.service.IArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author herixin
 * @create 2022-12-11 20:14
 */
@ResponseBody
public class ArticlesController {
    @Autowired
    private IArticlesService iArticlesService;
    public void select() {

    }

}

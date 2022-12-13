package com.test.service.impl;

import com.test.model.Articles;
import com.test.service.IArticlesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author herixin
 * @create 2022-12-11 21:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ArticlesServiceImplTest {
    @Autowired
    IArticlesService iArticlesService;

    @Test
    public void selectByPrimaryKey() {
        Articles articles = iArticlesService.selectByPrimaryKey(2);
        System.out.println(articles);
    }
}
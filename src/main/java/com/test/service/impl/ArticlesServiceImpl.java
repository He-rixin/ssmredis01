package com.test.service.impl;

import com.test.mapper.ArticlesMapper;
import com.test.model.Articles;
import com.test.service.IArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author herixin
 * @create 2022-12-11 20:13
 */
@Service
public class ArticlesServiceImpl implements IArticlesService {
    @Autowired
    private ArticlesMapper articlesMapper;
    @Override
    public Articles selectByPrimaryKey(Integer id) {
        return articlesMapper.selectByPrimaryKey(id);
    }
}

package com.test.service;

import com.test.mapper.ArticlesMapper;
import com.test.model.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author herixin
 * @create 2022-12-11 20:07
 */
public interface IArticlesService {
    @Cacheable("aa")
    Articles selectByPrimaryKey(Integer id);
}

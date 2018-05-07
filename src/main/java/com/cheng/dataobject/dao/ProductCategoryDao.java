package com.cheng.dataobject.dao;

import com.cheng.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author cheng
 *         2018/5/7 11:25
 */
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }
}

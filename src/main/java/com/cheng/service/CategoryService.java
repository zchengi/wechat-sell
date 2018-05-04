package com.cheng.service;

import com.cheng.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 *
 * @author cheng
 *         2018/5/4 17:39
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}

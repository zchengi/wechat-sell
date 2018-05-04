package com.cheng.service.impl;

import com.cheng.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * CategoryServiceImpl Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/04/2018</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void testFindOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void testFindAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void testFindByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void testSave() {
        ProductCategory productCategory = new ProductCategory("男生专享", 3);
        ProductCategory save = categoryService.save(productCategory);
    }
}

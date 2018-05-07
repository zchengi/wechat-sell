package com.cheng.dataobject.mapper;

import com.cheng.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * ProductCategoryMapper Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/07/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "zzz");
        map.put("categoryType", 101);
        int count = mapper.insertByMap(map);
        assertEquals(1, count);
    }

    @Test
    public void insertByObject() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("ccc");
        productCategory.setCategoryType(222);

        int count = mapper.insertByObject(productCategory);
        assertEquals(1, count);
    }

    @Test
    public void findByCategoryType() {

        ProductCategory result = mapper.findByCategoryType(1);
        assertNotNull(result);
    }

    @Test
    public void findByCategoryName() {

        List<ProductCategory> result = mapper.findByCategoryName("男生最爱");
        assertNotEquals(0, result);
    }

    @Test
    public void updateByCategoryType() {

        int result = mapper.updateByCategoryType("bbb", 222);
        assertEquals(1, result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("ccc");
        productCategory.setCategoryType(222);
        int result = mapper.updateByObject(productCategory);
        assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType() {

        int result = mapper.deleteByCategoryType(222);
        assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType() {

        ProductCategory result = mapper.selectByCategoryType(1);
        assertNotNull(result);
    }
}
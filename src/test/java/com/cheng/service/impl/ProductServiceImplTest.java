package com.cheng.service.impl;

import com.cheng.dataobject.ProductInfo;
import com.cheng.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ProductServiceImpl Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/04/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void testFindOne() {
        ProductInfo productInfo = productService.findOne("123");
        assertEquals("123", productInfo.getProductId());
    }

    @Test
    public void testFindUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void testFindAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        // System.out.println(productInfoPage.getTotalElements());
        assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void testSave() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("456");
        productInfo.setProductName("豆浆");
        productInfo.setProductPrice(new BigDecimal(3.3));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("好吃~~~");
        productInfo.setProductIcon("http://doujiang.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(6);

        ProductInfo result = productService.save(productInfo);
        assertNotNull(result);
    }

    @Test
    public void onSale() {
        ProductInfo productInfo = productService.onSale("123");
        assertEquals(ProductStatusEnum.UP.getCode(), productInfo.getProductStatus());
    }

    @Test
    public void offSale() {
        ProductInfo productInfo = productService.offSale("123");
        assertEquals(ProductStatusEnum.DOWN.getCode(), productInfo.getProductStatus());
    }
}

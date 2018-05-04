package com.cheng.repository;

import com.cheng.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * ProductInfoRepository Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/04/2018</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("油条");
        productInfo.setProductPrice(new BigDecimal(2.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好吃~~~");
        productInfo.setProductIcon("http://zzz.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(6);

        ProductInfo result = repository.save(productInfo);
        assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        assertNotEquals(0, productInfoList.size());
    }
}
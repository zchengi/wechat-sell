package com.cheng.repository;

import com.cheng.dataobject.SellerInfo;
import com.cheng.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * SellerInfoRepository Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/07/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void saveTest() {

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("cheng");
        sellerInfo.setPassword("zzz");
        sellerInfo.setOpenid("abc");

        SellerInfo result = repository.save(sellerInfo);
        assertNotNull(result);
    }

    @Test
    public void findByOpenidTest() {

        SellerInfo result = repository.findByOpenid("abc");
        assertEquals("cheng", result.getUsername());
    }
}
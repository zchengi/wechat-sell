package com.cheng.service.impl;

import com.cheng.dataobject.SellerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * SellerServiceImpl Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/07/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    @Autowired
    private SellerServiceImpl sellerService;

    private static final String openid = "abc";

    @Test
    public void FindSellerInfoByOpenIdTest() {

        SellerInfo result = sellerService.findSellerInfoByOpenId(openid);
        assertEquals(openid, result.getOpenid());
    }

} 

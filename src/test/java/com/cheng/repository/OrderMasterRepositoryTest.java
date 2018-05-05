package com.cheng.repository;

import com.cheng.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * ProductCategoryRepository Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/05/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "111";

    @Test
    public void saveTest() {

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("777");
        orderMaster.setBuyerName("cheng");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setBuyerAddress("cheng i");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(5.5));

        OrderMaster result = repository.save(orderMaster);
        assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {

        PageRequest request = new PageRequest(0, 3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        System.out.println(result.getTotalElements());

        assertNotEquals(0, result.getTotalElements());
    }
}
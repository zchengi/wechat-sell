package com.cheng.repository;

import com.cheng.dataobject.OrderDetail;
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
 * ProductCategoryRepository Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/05/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {


    @Autowired
    private OrderDetailRepository repository;

    private final String ORDER_ID = "777";

    @Test
    public void saveTest() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123");
        orderDetail.setOrderId(ORDER_ID);
        orderDetail.setProductId("666");
        orderDetail.setProductIcon("http://777.png");
        orderDetail.setProductName("youzi");
        orderDetail.setProductPrice(new BigDecimal(2.7));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);
        repository.save(orderDetail);
        assertNotNull(result);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetailList = repository.findByOrderId(ORDER_ID);
        assertNotEquals(0, orderDetailList.size());
    }
}
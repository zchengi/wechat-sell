package com.cheng.service.impl;

import com.cheng.dataobject.OrderDetail;
import com.cheng.dto.OrderDTO;
import com.cheng.enums.OrderStatusEnum;
import com.cheng.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * OrderServiceImpl Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>05/05/2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "11011";

    private final String ORDER_ID = "1525500317679789371";

    @Test
    public void CreateTest() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("cheng");
        orderDTO.setBuyerAddress("zzz");
        orderDTO.setBuyerPhone("12345678901");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        // 购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("789");
        orderDetail1.setProductQuantity(1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("456");
        orderDetail2.setProductQuantity(2);

        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);


        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result = {}", result);

        assertNotNull(result);
    }

    @Test
    public void FindOneTest() {

        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[查询单个订单] result = {}", result);
        assertNotNull(result);
    }

    @Test
    public void FindListTest() {

        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void listTest() {

        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void CancelTest() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void FinishTest() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void PaidTest() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}

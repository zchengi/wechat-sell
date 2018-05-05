package com.cheng.converter;

import com.cheng.dataobject.OrderMaster;
import com.cheng.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cheng
 *         2018/5/5 14:20
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream()
                .map(OrderMaster2OrderDTOConverter::convert)
                .collect(Collectors.toList());
    }
}

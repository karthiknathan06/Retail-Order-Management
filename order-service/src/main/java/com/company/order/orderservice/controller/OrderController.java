package com.company.order.orderservice.controller;

import com.company.order.orderservice.dto.OrderDto;
import com.company.order.orderservice.dto.OrderListDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class OrderController
{
    @GetMapping("/order/{userId}")
    public OrderListDto getOrder(@PathVariable("userId") String userId)
    {
        List<OrderDto> orderDtoList = Collections.singletonList(
                new OrderDto("231", "213", System.currentTimeMillis(), "")
        );
        OrderListDto orderListDto = new OrderListDto();
        orderListDto.setOrderList(orderDtoList);
        return orderListDto;
    }
}

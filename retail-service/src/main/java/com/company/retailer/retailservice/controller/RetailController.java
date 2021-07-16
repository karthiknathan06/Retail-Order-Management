package com.company.retailer.retailservice.controller;

import com.company.retailer.retailservice.dto.OrderDetailsDto;
import com.company.retailer.retailservice.dto.OrderListDto;
import com.company.retailer.retailservice.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RetailController
{
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/{userId}")
    public List<OrderDetailsDto> getProductInfo(@PathVariable("userId") String userId)
    {
        OrderListDto orderListDto = restTemplate.getForObject("http://order-service/order/"+ userId, OrderListDto.class);

        return orderListDto.getOrderList().stream().map(order ->
                {
                    ProductDto product = restTemplate.getForObject("http://product-service/product/"+ order.getProductId(), ProductDto.class);
                    return new OrderDetailsDto(order.getOrderId(), product.getProductName(), "new desc");
                })
                .collect(Collectors.toList());
    }
}

package com.company.product.productservice.controller;

import com.company.product.productservice.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("product")
@RestController
public class ProductController
{

    @GetMapping("/{productId}")
    public ProductDto getProductDetails(@PathVariable("productId") String productId)
    {
        return new ProductDto("123", "Hamam", "Soap variety");
    }
}

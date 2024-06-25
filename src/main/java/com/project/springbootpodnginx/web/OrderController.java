package com.project.springbootpodnginx.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Value("${POD_NAME:unknown}")
    private String podName;


    @GetMapping
    public String hello() {
        return "Hello, order from pod: " + podName;
    }
}

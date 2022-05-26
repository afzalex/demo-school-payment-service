package com.fz.demoschool.paymentservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {


    @GetMapping
    public String ping() {
        log.info("Ping is working properly in School Service.");
        return "Ping is working properly School Service";
    }

}


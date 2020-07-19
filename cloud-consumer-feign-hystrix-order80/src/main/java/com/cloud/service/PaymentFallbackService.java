package com.cloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentHystrixService {


    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务降级 PaymentFallbackService fallback paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务降级 PaymentFallbackService fallback paymentInfo_TimeOut";
    }
}

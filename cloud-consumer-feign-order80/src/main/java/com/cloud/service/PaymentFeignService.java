package com.cloud.service;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description :
 * Author      : Guojingbin
 * Create      : 2020.7.16 18:09
 * Version     : 1.0
 */

@Component
//调用哪个服务中的接口
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //调用服务中的接口的方法
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}

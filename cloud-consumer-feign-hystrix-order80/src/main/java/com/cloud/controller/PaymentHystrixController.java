package com.cloud.controller;

import com.cloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//全局服务降级
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod", commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//})
public class PaymentHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    //})
    //@HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int age = 10 / 0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "  系统繁忙! id:" + id + "! 客户端Hystrix Command fallback";
    }

    public String payment_Global_FallbackMethod() {
        return " 全局服务降级处理   信息提示";
    }
}

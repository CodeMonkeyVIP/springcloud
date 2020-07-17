package com.cloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "!!!!!";
    }

    public String paymentInfo_TimeOut(Integer id) {
        try {
            int time = 3;
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "! 耗时3s";
    }
}

package com.cloud.service.impl;

import javax.annotation.Resource;

import com.cloud.dao.PaymentDao;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;

import org.springframework.stereotype.Service;

/**
 * @auther zzyy
 * @create 2020-02-18 10:40
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}

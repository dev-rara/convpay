package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PaymentResult;

public interface PaymentInterface {     //Interface는 public 하므로 접근제어자 불필요
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
    PayMethodType getPayMethodType();
}

package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//편결이(편의점 결제서비스)
//결제요청을 받아 결제응답 반환
@Component
public class ConveniencePayService {
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountByConvenience) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethodType(), paymentInterface)
        );
        this.discountInterface = discountByConvenience;
    }

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(
                payRequest.getPayMethodType());

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);


        if(paymentResult == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(
                payCancelRequest.getPayMethodType());

        CancelPaymentResult cancelPayment = paymentInterface.cancelPayment(
                payCancelRequest.getPayCancelAmount());

        if(cancelPayment == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}

package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;

public class MoneyAdapter {

    public MoneyUseResult use(Integer payAmount) {
        System.out.println("MoneyAdapter.use: " + payAmount);

        if(payAmount > 1000_000) {   //금액이 너무 큰 경우 FAIL
            return MoneyUseResult.USE_FAIL;
        }
        return MoneyUseResult.USE_SUCCESS;
    }

    public MoneyUseCancelResult useCancel(Integer payCancelAmount) {
        System.out.println("MoneyAdapter.useCancel: " + payCancelAmount);

        if(payCancelAmount < 100 ) {   //금액이 너무 큰 경우 FAIL
            return MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL;
        }
        return MoneyUseCancelResult. MONEY_USE_CANCEL_SUCCESS;
    }
}

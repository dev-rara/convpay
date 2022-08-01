package com.zerobase.convpay.config;

import com.zerobase.convpay.service.*;

import java.util.Arrays;
import java.util.HashSet;

public class ApplicationConfig {       //어플리케이션 전체의 설정을 담당하는 클래스

    public ConveniencePayService conveniencePayServiceDiscountPayMethod() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByPayMethod()
        );
    }

    public ConveniencePayService conveniencePayServiceDiscountConvenience() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByConvenience()
        );
    }
}

package com.zerobase.convpay.config;

import com.zerobase.convpay.ConvpayApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@ComponentScan(basePackageClasses = ConvpayApplication.class)
public class ApplicationConfig {       //어플리케이션 전체의 설정을 담당하는 클래스

}

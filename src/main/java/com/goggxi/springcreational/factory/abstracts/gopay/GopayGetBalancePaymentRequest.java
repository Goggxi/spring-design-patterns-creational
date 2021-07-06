package com.goggxi.springcreational.factory.abstracts.gopay;

import com.goggxi.springcreational.factory.abstracts.GetBalancePaymentRequest;
import com.goggxi.springcreational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class GopayGetBalancePaymentRequest implements GetBalancePaymentRequest {

    @Getter
    @Setter
    private String userId;

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.GOPAY;
    }

}

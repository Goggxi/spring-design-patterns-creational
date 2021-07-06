package com.goggxi.springcreational.factory.abstracts.gopay;

import com.goggxi.springcreational.factory.abstracts.ChargePaymentRequest;
import com.goggxi.springcreational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class GopayChargePaymentRequest implements ChargePaymentRequest {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Long amount;

    @Override
    public Long getFee() {
        return 7000L;
    }

    @Override
    public PaymentMethod getMethode() {
        return PaymentMethod.GOPAY;
    }
}

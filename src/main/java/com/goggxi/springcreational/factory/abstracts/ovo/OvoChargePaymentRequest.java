package com.goggxi.springcreational.factory.abstracts.ovo;

import com.goggxi.springcreational.factory.abstracts.ChargePaymentRequest;
import com.goggxi.springcreational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class OvoChargePaymentRequest implements ChargePaymentRequest {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Long amount;

    @Override
    public Long getFee() {
        return getAmount() * 5 / 100;
    }

    @Override
    public PaymentMethod getMethode() {
        return PaymentMethod.OVO;
    }
}

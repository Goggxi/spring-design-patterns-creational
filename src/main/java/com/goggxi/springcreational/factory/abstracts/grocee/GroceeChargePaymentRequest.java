package com.goggxi.springcreational.factory.abstracts.grocee;

import com.goggxi.springcreational.factory.abstracts.ChargePaymentRequest;
import com.goggxi.springcreational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class GroceeChargePaymentRequest implements ChargePaymentRequest {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Long amount;

    @Override
    public Long getFee() {
        return 5000L;
    }

    @Override
    public PaymentMethod getMethode() {
        return PaymentMethod.GROCEE;
    }

}

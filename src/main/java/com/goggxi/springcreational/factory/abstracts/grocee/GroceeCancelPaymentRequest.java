package com.goggxi.springcreational.factory.abstracts.grocee;

import com.goggxi.springcreational.factory.abstracts.CancelPaymentRequest;
import com.goggxi.springcreational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class GroceeCancelPaymentRequest implements CancelPaymentRequest {

    @Getter
    @Setter
    private String id;

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.GROCEE;
    }
}

package com.goggxi.springcreational.factory.abstracts.ovo;

import com.goggxi.springcreational.factory.abstracts.CancelPaymentRequest;
import com.goggxi.springcreational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class OvoCancelPaymentRequest implements CancelPaymentRequest {

    @Getter
    @Setter
    private String id;

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.OVO;
    }
}

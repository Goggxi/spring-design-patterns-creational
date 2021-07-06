package com.goggxi.springcreational.factory.abstracts.ovo;

import com.goggxi.springcreational.factory.abstracts.GetBalancePaymentRequest;
import com.goggxi.springcreational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class OvoGetBalancePaymentRequest implements GetBalancePaymentRequest {

    @Getter
    @Setter
    private String userId;

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.OVO;
    }
}

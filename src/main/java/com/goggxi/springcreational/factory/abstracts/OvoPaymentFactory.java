package com.goggxi.springcreational.factory.abstracts;

import com.goggxi.springcreational.factory.abstracts.ovo.OvoCancelPaymentRequest;
import com.goggxi.springcreational.factory.abstracts.ovo.OvoChargePaymentRequest;
import com.goggxi.springcreational.factory.abstracts.ovo.OvoGetBalancePaymentRequest;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OvoPaymentFactory implements PaymentFactory{

    @Override
    public ChargePaymentRequest createChargeRequest() {
        return new OvoChargePaymentRequest();
    }

    @Override
    public CancelPaymentRequest cancelCancelRequest() {
        return new OvoCancelPaymentRequest();
    }

    @Override
    public GetBalancePaymentRequest createGetBalanceRequest() {
        return new OvoGetBalancePaymentRequest();
    }
}

package com.goggxi.springcreational.factory.abstracts;

import com.goggxi.springcreational.factory.abstracts.grocee.GroceeCancelPaymentRequest;
import com.goggxi.springcreational.factory.abstracts.grocee.GroceeChargePaymentRequest;
import com.goggxi.springcreational.factory.abstracts.grocee.GroceeGetBalancePaymentRequest;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroceePaymentFactory implements PaymentFactory{

    @Override
    public ChargePaymentRequest createChargeRequest() {
        return new GroceeChargePaymentRequest();
    }

    @Override
    public CancelPaymentRequest cancelCancelRequest() {
        return new GroceeCancelPaymentRequest();
    }

    @Override
    public GetBalancePaymentRequest createGetBalanceRequest() {
//        throw new UnsupportedOperationException("Unsupported Get Balance in Grocee pay");
        return new GroceeGetBalancePaymentRequest();
    }
}

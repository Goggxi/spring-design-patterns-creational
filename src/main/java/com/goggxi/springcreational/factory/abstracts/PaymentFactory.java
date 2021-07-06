package com.goggxi.springcreational.factory.abstracts;

public interface PaymentFactory {

    ChargePaymentRequest createChargeRequest();

    CancelPaymentRequest cancelCancelRequest();

    GetBalancePaymentRequest createGetBalanceRequest();

}

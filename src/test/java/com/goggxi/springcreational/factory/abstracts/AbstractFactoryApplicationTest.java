package com.goggxi.springcreational.factory.abstracts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = AbstractFactoryApplication.class)
class AbstractFactoryApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testAbstractFactory() {
        PaymentFactory paymentFactoryOvo = applicationContext.getBean(OvoPaymentFactory.class);
        PaymentFactory paymentFactoryGrocee = applicationContext.getBean(GroceePaymentFactory.class);
        PaymentFactory paymentFactoryGopay = applicationContext.getBean(GopayPaymentFactory.class);

        charge(paymentFactoryOvo);
        charge(paymentFactoryGrocee);
        charge(paymentFactoryGopay);
    }

    public void charge(PaymentFactory paymentFactory) {
        ChargePaymentRequest request = paymentFactory.createChargeRequest();
        request.setId("xxx");
        request.setAmount(1000000L);

        // Send to payment gateway
        System.out.println(request);
    }

    public void cancel(PaymentFactory paymentFactory) {
        CancelPaymentRequest request = paymentFactory.cancelCancelRequest();
        request.setId("xxx");

        // Sent to payment gateway
        System.out.println(request);
    }

    public Long getBalance(PaymentFactory paymentFactory) {
        try {
            GetBalancePaymentRequest request = paymentFactory.createGetBalanceRequest();
            request.setUserId("goggxi");

            System.out.println(request);

            // Send to payment gateway
            return 1000L;
        } catch (UnsupportedOperationException e) {
            return 0L;
        }
    }

}
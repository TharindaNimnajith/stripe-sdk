package com.example.stripesdk.services;

import com.example.stripesdk.models.TransactionData;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.example.stripesdk.util.Constants.API_KEY;

@Service
public class StripeService {

    public ResponseEntity<Session> createSession(final TransactionData transactionData) throws StripeException {
        Stripe.apiKey = API_KEY;

        SessionCreateParams params = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl(transactionData.getSuccessUrl())
            .setCancelUrl(transactionData.getCancelUrl())
            .addLineItem(SessionCreateParams.LineItem.builder()
                .setQuantity(transactionData.getQuantity())
                .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                    .setCurrency(transactionData.getCurrency())
                    .setUnitAmount(transactionData.getAmount())
                    .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(transactionData.getProductName())
                        .build())
                    .build())
                .build())
            .build();

        return ResponseEntity.ok(Session.create(params));
    }
}

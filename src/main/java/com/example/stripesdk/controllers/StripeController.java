package com.example.stripesdk.controllers;

import com.example.stripesdk.models.TransactionData;
import com.example.stripesdk.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StripeController {

    private final StripeService stripeService;

    @PostMapping("/payment")
    public ResponseEntity<Session> payment(@RequestBody TransactionData data) throws StripeException {
        return stripeService.payment(data);
    }
}

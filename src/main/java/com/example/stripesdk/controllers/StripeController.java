package com.example.stripesdk.controllers;

import com.example.stripesdk.models.TransactionData;
import com.example.stripesdk.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StripeController {

    private final StripeService stripeService;

    @PostMapping("/create-session")
    public ResponseEntity<Session> createSession(@RequestBody TransactionData transactionData) throws StripeException {
        return stripeService.createSession(transactionData);
    }

    @GetMapping("/success")
    public String success() {
        return "Success";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "Cancel";
    }
}

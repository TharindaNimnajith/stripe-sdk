package com.example.stripesdk.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactionData {

    private String successUrl;
    private String cancelUrl;
    private Long quantity;
    private String currency;
    private Long amount;
    private String productName;
}

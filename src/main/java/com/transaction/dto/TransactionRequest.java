package com.transaction.dto;


import lombok.Data;

@Data
public class TransactionRequest {

    private String accountSource;
    private String accountTarget;
    private Double amount;

}

package com.transaction.exception;

import java.text.MessageFormat;

public class AmountNotEnoughException extends RuntimeException{

    public AmountNotEnoughException(String amountNotEnough){
        super(MessageFormat.format("Your Amount Not Enough!: {0}", amountNotEnough));
    }
}

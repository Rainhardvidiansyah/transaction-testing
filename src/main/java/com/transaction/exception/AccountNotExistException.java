package com.transaction.exception;

import java.text.MessageFormat;

public class AccountNotExistException extends RuntimeException{

    public AccountNotExistException(String notExist) {
        super(MessageFormat.format("Account Doens't exit: {0}", notExist));
    }
}

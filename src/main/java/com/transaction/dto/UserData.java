package com.transaction.dto;

import com.transaction.entity.Account;
import lombok.Data;

@Data
public class UserData {

    private String accNumber;

    private String name;

    private Double balance;

    public static UserData dataChanging(Account account){
        UserData data = new UserData();
        data.setAccNumber(account.getAccNumber());
        data.setName(account.getName());
        data.setBalance(account.getBalance());
        return data;
    }
}

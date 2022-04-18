package com.transaction.service;

import com.transaction.entity.Account;
import com.transaction.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public Account createAccount(Account acc){
        return accountRepo.save(acc);
    }

    public List<Account> findAllAccount(){
        return accountRepo.findAll();
    }



}

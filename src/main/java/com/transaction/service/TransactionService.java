package com.transaction.service;

import com.transaction.entity.Account;
import com.transaction.exception.AccountNotExistException;
import com.transaction.exception.AmountNotEnoughException;
import com.transaction.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private AccountRepo accountRepo;

    public Account createAccount(Account acc){
        return accountRepo.save(acc);
    }

    public List<Account> findAllAccount(){
        return accountRepo.findAll();
    }


    @Transactional
    public void transactionProcess(String sourceAccount, String targetAccount, Double amount) {
        Account accSource = accountRepo.findByAccNumber(sourceAccount);
        if(accSource == null){
            throw new AccountNotExistException("Account Doesn't exist!");
        }
        if(accSource.getBalance() < amount){
            throw new AmountNotEnoughException("Balance not Enough!");
        }

        accSource.setBalance(accSource.getBalance() - amount);
        accountRepo.save(accSource);

        Account target = accountRepo.findByAccNumber(targetAccount);
        if(target == null){
            throw new AccountNotExistException("Account Doesn't Exit");
        }

        target.setBalance(target.getBalance() + amount);
        accountRepo.save(target);
    }



}

package com.transaction.controller;


import com.transaction.dto.TransactionRequest;
import com.transaction.dto.UserData;
import com.transaction.entity.Account;
import com.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{s}")
    public String sayHallo(@PathVariable("s") String s){
       return "Halo " + s;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAccount(@RequestBody Account account){
         accountService.createAccount(account);
         return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/transaction")
    public ResponseEntity<?> TransactionProcess(@RequestBody TransactionRequest request){
        accountService.transactionProcess(request.getAccountSource(),
                request.getAccountTarget(), request.getAmount());
        return new ResponseEntity<>("Transaction succeed to:" + request.getAccountTarget(), HttpStatus.OK);
            }
}

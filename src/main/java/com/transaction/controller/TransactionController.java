package com.transaction.controller;


import com.transaction.dto.TransactionRequest;
import com.transaction.entity.Account;
import com.transaction.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{s}")
    public String sayHallo(@PathVariable("s") String s){
       return "Halo " + s;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAccount(@RequestBody Account account){
         transactionService.createAccount(account);
         return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/transaction")
    public ResponseEntity<?> TransactionProcess(@RequestBody TransactionRequest request){
        transactionService.transactionProcess(request.getAccountSource(),
                request.getAccountTarget(), request.getAmount());
        return new ResponseEntity<>("Transaction succeed to:" + request.getAccountTarget(), HttpStatus.OK);
            }
}

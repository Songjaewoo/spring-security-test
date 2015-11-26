package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceBean implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
    	Account account = accountRepository.findByUsername(username);
    	
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> findByUsername");
        return account;
    }

}

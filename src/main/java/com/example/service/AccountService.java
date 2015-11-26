package com.example.service;

import com.example.model.Account;

public interface AccountService {
    Account findByUsername(String username);
}

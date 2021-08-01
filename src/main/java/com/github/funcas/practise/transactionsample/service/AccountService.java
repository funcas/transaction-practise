package com.github.funcas.practise.transactionsample.service;

import com.github.funcas.practise.transactionsample.entity.Account;
import com.github.funcas.practise.transactionsample.entity.User;

/**
 * TODO
 *
 * @author funcas
 * @since 1.0
 */
public interface AccountService {

    void createAccount(Account account, User user);


}

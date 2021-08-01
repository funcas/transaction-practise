package com.github.funcas.practise.transactionsample.service.impl;

import com.github.funcas.practise.transactionsample.entity.Account;
import com.github.funcas.practise.transactionsample.entity.User;
import com.github.funcas.practise.transactionsample.repository.AccountRepository;
import com.github.funcas.practise.transactionsample.service.AccountService;
import com.github.funcas.practise.transactionsample.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author funcas
 * @since 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;

    public AccountServiceImpl(AccountRepository accountRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }


    @Override
    @Transactional
    public void createAccount(Account account, User user) {
         Account acc = accountRepository.save(account);

         user.setAccountId(acc.getId());

        try {
            userService.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

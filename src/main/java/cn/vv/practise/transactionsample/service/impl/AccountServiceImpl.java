package cn.vv.practise.transactionsample.service.impl;

import cn.vv.practise.transactionsample.entity.Account;
import cn.vv.practise.transactionsample.entity.User;
import cn.vv.practise.transactionsample.repository.AccountRepository;
import cn.vv.practise.transactionsample.service.AccountService;
import cn.vv.practise.transactionsample.service.UserService;
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

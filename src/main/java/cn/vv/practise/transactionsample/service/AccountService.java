package cn.vv.practise.transactionsample.service;

import cn.vv.practise.transactionsample.entity.Account;
import cn.vv.practise.transactionsample.entity.User;

/**
 * TODO
 *
 * @author funcas
 * @since 1.0
 */
public interface AccountService {

    void createAccount(Account account, User user);


}

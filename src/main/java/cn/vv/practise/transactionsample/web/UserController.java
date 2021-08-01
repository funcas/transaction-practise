package cn.vv.practise.transactionsample.web;

import cn.vv.practise.transactionsample.entity.Account;
import cn.vv.practise.transactionsample.entity.User;
import cn.vv.practise.transactionsample.service.AccountService;
import cn.vv.practise.transactionsample.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author funcas
 * @since 1.0
 */
@RestController
@RequestMapping("/test")
public class UserController {

    private final UserService userService;
    private final AccountService accountService;

    public UserController(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @PostMapping("/v1")
    public Object test1(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @PostMapping("/v2")
    public Object test2(@RequestBody AccountDTO dto) {
        accountService.createAccount(dto.getAccount(), dto.getUser());
        return dto.account.getUsername();
    }

    @GetMapping("/findUser")
    public Object findUser(String name) {
        return userService.findUsersByName(name);
    }


    static class AccountDTO {
        private User user;
        private Account account;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }
    }
}

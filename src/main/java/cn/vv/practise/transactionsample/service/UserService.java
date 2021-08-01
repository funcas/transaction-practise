package cn.vv.practise.transactionsample.service;

import cn.vv.practise.transactionsample.entity.User;

import java.util.List;

/**
 * TODO
 *
 * @author funcas
 * @since 1.0
 */
public interface UserService {

    void saveUser(User user);

    List<User> findUsersByName(String name);
    void createUser(User entity);
}

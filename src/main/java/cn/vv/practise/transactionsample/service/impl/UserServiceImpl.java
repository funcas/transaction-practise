package cn.vv.practise.transactionsample.service.impl;

import cn.vv.practise.transactionsample.entity.User;
import cn.vv.practise.transactionsample.repository.UserRepository;
import cn.vv.practise.transactionsample.service.UserService;
import com.google.common.collect.Lists;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author funcas
 * @version 1.0
 * @date 2020年06月20日
 */
@Service
public class UserServiceImpl implements UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    private UserServiceImpl _this;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {

//        _this.createUser(user);
        ((UserServiceImpl) AopContext.currentProxy()).createUserRight3(user);
//        return userRepository.save(user);
    }

    @Transactional
    private void createUserWrong1(User entity) {
        userRepository.save(entity);
        int a = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createUser(User entity) {
        userRepository.save(entity);
        int a = 1 / 0;
    }


    @Transactional
    public void createUserWrong2(User entity) {
        try {
            userRepository.save(entity);
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void createUserWrong3(User entity) throws IOException {
        userRepository.save(entity);
        IOUtils.readFully(new FileInputStream("a.txt"), new byte[1024]);
    }


    @Transactional
    public void createUserRight3(User entity) {
        userRepository.save(entity);
        try {
            IOUtils.readFully(new FileInputStream("a.txt"), new byte[1024]);
        } catch (IOException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }



    @Override
//    @Transactional(readOnly = true)
    public List<User> findUsersByName(String name) {
        List<User> users = userRepository.findByName(name);
        logger.info("user count => {}", users.size());
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<User> users2 = userRepository.findByName(name);
        logger.info("users count => {}", users2.size());
        return Lists.newArrayList();
    }

}

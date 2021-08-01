package cn.vv.practise.transactionsample.repository;

import cn.vv.practise.transactionsample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author funcas
 * @version 1.0
 * @date 2020年06月20日
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByName(String name);
}

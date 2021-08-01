package com.github.funcas.practise.transactionsample.repository;

import com.github.funcas.practise.transactionsample.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author funcas
 * @since 1.0
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}

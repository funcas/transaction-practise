package com.github.funcas.practise.transactionsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class TransactionSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionSampleApplication.class, args);
    }

}

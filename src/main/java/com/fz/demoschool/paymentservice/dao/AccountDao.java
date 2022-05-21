package com.fz.demoschool.paymentservice.dao;


import com.fz.demoschool.paymentservice.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountDao extends MongoRepository<Account, String> {
}

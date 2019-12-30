package com.qf.mapper;

import com.qf.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {

    public List<Account> findList();
}

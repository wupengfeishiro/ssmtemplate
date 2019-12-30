package com.qf.service;

import com.qf.entity.Account;
import com.qf.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public List<Account> findList() {
        return testMapper.findList();
    }
}

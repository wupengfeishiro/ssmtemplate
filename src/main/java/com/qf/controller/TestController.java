package com.qf.controller;

import com.qf.entity.Account;
import com.qf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/account")
public class TestController {

    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping("findList")
    public List<Account> findList() {
        List<Account> list = testService.findList();
        return list;
    }
}

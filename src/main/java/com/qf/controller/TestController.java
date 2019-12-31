package com.qf.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.entity.Account;
import com.qf.entity.Person;
import com.qf.service.TestService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping("/account")
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping("view")
    public String view() {
        return "views/mvc/data";
    }

    @ResponseBody
    @RequestMapping("findList")
    public List<Account> findList() {
        List<Account> list = testService.findList();
        return list;
    }

    @ResponseBody
    @RequestMapping("shuzu")
    public String shuzu(String[] mine) {
        System.out.println("数组长度为：" + mine.length);
        for (int i = 0; i < mine.length; i++) {
            System.out.println(mine[i]);
        }
        return mine.length + "";
    }

    @ResponseBody
    @RequestMapping("array")
    public String array(Account account) {
        try {
            String persons = account.getPersonsList();
            // &quot;转义成双引号
            String personStr = StringEscapeUtils.unescapeHtml4(persons);
            //将字符串转化为JSONArray
            JSONArray jsonArray = JSONArray.parseArray(personStr);
            if (jsonArray.size() > 0) {
                for (Object obj : jsonArray) {
                    JSONObject json = (JSONObject) obj;
                    Person person = JSONObject.toJavaObject(json, Person.class);
                    System.out.println(person.getName());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return "";
    }
}

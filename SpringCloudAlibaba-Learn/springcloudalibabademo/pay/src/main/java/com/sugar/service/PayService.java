package com.sugar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PayService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save() {
        this.jdbcTemplate.update("insert into `pay`(username) values ('张三')");
    }
}

package com.water.kaka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FoorServiceImpl implements FoorService {

    @Autowired
    @Qualifier("kakaJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("insert into kaka.user values (10, 'kongkong', 25)");
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertRecordThenRollBack() throws RuntimeException {
        jdbcTemplate.execute("insert into kaka.user values (10, 'kongkong', 25)");
        throw new RuntimeException();

    }

    @Override
    public void invokeInsertThenRollBack() throws RuntimeException{
        insertRecordThenRollBack();
    }
}

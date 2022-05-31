package com.laptrinhjava.dao;

import java.util.List;

import com.laptrinhjava.mapper.RowMapper;


public interface GenericDAO<T> {

    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

    Integer insert(String sql, Object... parameters);

    void updateordelete(String sql, Object... parameters);

    int count(String sql, Object... parameters);
}

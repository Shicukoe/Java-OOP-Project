package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.mapper.RowMapper;

public interface GenericDAO<T> {
    @SuppressWarnings("hiding")
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object ... parameters);

}

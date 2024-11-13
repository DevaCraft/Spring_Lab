package com.pdp.oidc.oidc_lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class NativeQueryExecutor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Executes a native SQL query and returns the result as a List of Maps.
     * Each Map represents a row from the result set with column names as keys.
     *
     * @param query The SQL query to execute.
     * @return A List of Maps containing the results.
     */
    public List<Map<String, Object>> executeQuery(String query) {
        return jdbcTemplate.queryForList(query);
    }

    /**
     * Executes a native SQL query with parameters and returns the result as a List of Maps.
     * Each Map represents a row from the result set with column names as keys.
     *
     * @param query The SQL query to execute.
     * @param params The parameters to bind to the query.
     * @return A List of Maps containing the results.
     */
    public List<Map<String, Object>> executeQueryWithParams(String query, Object[] params) {
        return jdbcTemplate.queryForList(query, params);
    }

    /**
     * Executes an update query and returns the number of affected rows.
     *
     * @param query The SQL update query to execute.
     * @return The number of rows affected.
     */
    public int executeUpdate(String query) {
        return jdbcTemplate.update(query);
    }

    /**
     * Executes an update query with parameters and returns the number of affected rows.
     *
     * @param query The SQL update query to execute.
     * @param params The parameters to bind to the query.
     * @return The number of rows affected.
     */
    public int executeUpdateWithParams(String query, Object[] params) {
        return jdbcTemplate.update(query, params);
    }
}

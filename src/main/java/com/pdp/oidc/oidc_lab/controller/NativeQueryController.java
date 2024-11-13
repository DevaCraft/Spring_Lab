package com.pdp.oidc.oidc_lab.controller;

import com.pdp.oidc.oidc_lab.service.NativeQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class NativeQueryController {

    @Autowired
    private NativeQueryExecutor nativeQueryExecutor;

    @GetMapping("/execute-query/{query}")
    public List<Map<String, Object>> executeQuery(@PathVariable String query) {
        return nativeQueryExecutor.executeQuery(query);
    }

    @GetMapping("/execute-query-with-params")
    public List<Map<String, Object>> executeQueryWithParams() {
        String query = "SELECT * FROM employee WHERE department = ?";
        Object[] params = new Object[] {"HR"};
        return nativeQueryExecutor.executeQueryWithParams(query, params);
    }
}

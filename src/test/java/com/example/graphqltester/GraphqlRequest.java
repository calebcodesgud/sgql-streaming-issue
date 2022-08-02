package com.example.graphqltester;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class GraphqlRequest {

    private String query;

    private final Map<String, Object> variables = new LinkedHashMap<>();

    public GraphqlRequest(String query) {
        this.query = query;
    }
}

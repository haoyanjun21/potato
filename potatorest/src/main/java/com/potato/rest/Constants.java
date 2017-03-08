package com.potato.rest;

import java.util.HashMap;

/**
 * Created by bjhaoyanjun on 2017/3/8.
 */
public class Constants {
    public static final HashMap<String, String> FUNCTION_URL;

    static {
        FUNCTION_URL = new HashMap<String, String>();
        FUNCTION_URL.put("1", "http://hyj1:8080/soa/");
        FUNCTION_URL.put("4", "http://hyj4:8080/soa/");
    }

    public static String getTargetUrlBy(String function) {
        return FUNCTION_URL.get(function);
    }
}

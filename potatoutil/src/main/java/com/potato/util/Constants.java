package com.potato.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bjhaoyanjun on 2017/3/8.
 */
public class Constants {
    /**
     * 接口-url 映射
     */
    private static final Map FUNCTION_URL_MAP = new ConcurrentHashMap();
    /**
     * url-限流器 映射
     */
    private static final Map URL_LIMITER_MAP = new ConcurrentHashMap();
    private static String url1 = "http://hyj1:8080/soa/";
    private static String url4 = "http://hyj4:8080/soa/";

    static {
        FUNCTION_URL_MAP.put("1", url1);
        FUNCTION_URL_MAP.put("4", url4);
        URL_LIMITER_MAP.put(url1, RateLimiter.create(10.0));
        URL_LIMITER_MAP.put(url4, RateLimiter.create(40.0));
    }

    /**
     * 通过接口名获取目标url
     *
     * @param function
     * @return
     */
    public static String getTargetUrlBy(final String function) {
        return (String) FUNCTION_URL_MAP.get(function);
    }

    /**
     * 通过url获取限流器
     *
     * @param url
     * @return
     */
    public static RateLimiter getLimiterBy(final String url) {
        return (RateLimiter) URL_LIMITER_MAP.get(url);
    }
}

package com.potato.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bjhaoyanjun on 2017/3/8.
 */
public class Constants {
    public static final String[] HOSTNAME_ARRAY = {"hyj1", "hyj4"};
    /**
     * 接口-url 映射
     */
    private static final Map FUNCTION_URL_MAP = new ConcurrentHashMap();
    /**
     * url-限流器 映射
     */
    private static final Map URL_LIMITER_MAP = new ConcurrentHashMap();
    private static String hyj1 = "http://hyj1:8080/soa/";
    private static String hyj4 = "http://hyj4:8080/soa/";

    static {
        FUNCTION_URL_MAP.put("1", hyj1);
        FUNCTION_URL_MAP.put("4", hyj4);
        URL_LIMITER_MAP.put(hyj1, RateLimiter.create(2.0));
        URL_LIMITER_MAP.put(hyj4, RateLimiter.create(200.0));
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

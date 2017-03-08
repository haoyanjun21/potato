package com.potato.rest;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by bjhaoyanjun on 2017/3/8.
 */
@Component
public class APIProxy {
    static final RateLimiter rateLimiter = RateLimiter.create(20.0);

    public static String function(String function) {
        rateLimiter.acquire(); // 也许需要等待
        String url = Constants.getTargetUrlBy(function);
        try {
            if (StringUtils.isNotEmpty(url)) {
                return HttpClientUtil.get(url + function);
            } else {
                return "function is not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


}

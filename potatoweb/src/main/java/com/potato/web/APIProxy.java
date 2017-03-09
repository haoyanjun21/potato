package com.potato.web;

import com.potato.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by bjhaoyanjun on 2017/3/8.
 */
@Component
public class APIProxy {

    /**
     * 调用函数的代理，内部加了限流、熔断
     *
     * @param function
     * @return
     */
    public String function(final String function) {
        final String url = Constants.getTargetUrlBy(function);
        String result;
        if (StringUtils.isNotEmpty(url)) {
            Constants.getLimiterBy(url).acquire();  //限流
            result = new FunctionCommand(url + function).execute();  //熔断
        } else {
            result = "function is not found";
        }
        return result;
    }

}



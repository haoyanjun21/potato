package com.potato.web;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.potato.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;

class FunctionCommand extends HystrixCommand<String> {
    @Autowired
    private HttpClientService httpClientService;

    private final String url;

    public FunctionCommand(String url) {
        super(HystrixCommandGroupKey.Factory.asKey("FunctionGroup"));
        this.url = url;
    }

    @Override
    protected String run() {
        //关键点：把一个RPC调用，封装在一个HystrixCommand里面
        return httpClientService.doGet(url );
    }

}
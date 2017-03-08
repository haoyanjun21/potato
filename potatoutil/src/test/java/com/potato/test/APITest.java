package com.potato.test;


import com.potato.util.HttpClientUtil;

/**
 * Created by bjhaoyanjun on 2017/3/8.
 */
public class APITest {

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8080/api/";
        String result;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            result = HttpClientUtil.get(url + (i % 5));
            System.out.println(result);
        }
        System.out.println("total cost:" + (System.currentTimeMillis() - start));
    }
}

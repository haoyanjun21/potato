package com.potato.test;


import com.potato.util.HttpClientUtil;

/**
 * Created by bjhaoyanjun on 2017/3/8.
 */
public class APITest {

    public static void main(String[] args) throws Exception {
        int[] functions = {1, 4};
        String url = "http://localhost:8080/api/";
        String result;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            result = HttpClientUtil.get(url + (functions[i % 2]));
            System.out.println(result);
        }
        System.out.println("total cost:" + (System.currentTimeMillis() - start));
    }
}

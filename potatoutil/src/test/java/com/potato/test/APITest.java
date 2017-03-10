package com.potato.test;


import com.potato.util.HttpClientUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bjhaoyanjun on 2017/3/8.
 */
public class APITest {

    public static void main(String[] args) throws Exception {
        int[] functions = {1, 4};
        String url = "http://localhost:8080/api/";
        int functionNum = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(functionNum);
        CountDownLatch countDownLatch = new CountDownLatch(functionNum);
        for (int i = 0; i < functionNum; i++) {
            int finalI = i;
            executorService.execute(() -> {
                long start = System.currentTimeMillis();
                for (int j = 0; j < 100; j++) {
                    String result = HttpClientUtil.get(url + (functions[finalI]));
                    System.out.println(result);
                }
                countDownLatch.countDown();
                System.out.println(functions[finalI] + " total cost :" + (System.currentTimeMillis() - start));
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }


}

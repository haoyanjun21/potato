package com.potato.rest;

import com.google.common.util.concurrent.RateLimiter;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by bjhaoyanjun on 2017/3/5.
 */
public class RateLimiterTest {
    /**
     * 举例来说明如何使用RateLimiter，想象下我们需要处理一个任务列表，但我们不希望每秒的任务提交超过两个：
     */

//速率是每秒两个许可
    final RateLimiter rateLimiter = RateLimiter.create(2.0);

    void submitTasks(List<Runnable> tasks, Executor executor) {
        for (Runnable task : tasks) {
            rateLimiter.acquire(); // 也许需要等待
            executor.execute(task);
        }
    }

    /**
     * 想象下我们制造了一个数据流，并希望以每秒5kb的速率处理它。可以通过要求每个字节代表一个许可，然后指定每秒5000个许可来完成：
     */
// 每秒5000个许可
//    final RateLimiterTest rateLimiter = RateLimiter.create(5000.0);
    void submitPacket(byte[] packet) {
        rateLimiter.acquire(packet.length);
//        networkService.send(packet);
    }

}

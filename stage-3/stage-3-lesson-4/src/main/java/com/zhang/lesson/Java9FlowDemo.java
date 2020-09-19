package com.zhang.lesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Java9FlowDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/20 1:22
 * @Version 1.0
 **/
public class Java9FlowDemo {
    public static void main(String[] args) throws InterruptedException {
        try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>()) {
            publisher.subscribe(new Flow.Subscriber<String>() {

                private Flow.Subscription subscription;

                @Override
                public void onSubscribe(Flow.Subscription subscription) {
                    this.subscription = subscription;
                    println("已订阅：" + subscription);
                    subscription.request(Integer.MAX_VALUE);
                }

                @Override
                public void onNext(String item) {
                    if ("exit".equals(item)) {
                        subscription.cancel();
                        return;
                    } else if ("exception".equalsIgnoreCase(item)) {
                        throw new RuntimeException("Throw an exception...");
                    }
                    println("得到数据：" + item);
                }

                @Override
                public void onError(Throwable throwable) {
                    println("得到异常：" + throwable);
                }

                @Override
                public void onComplete() {
                    println("操作完成");
                }
            });
            // 发布者发布数据
            publisher.submit("Hello, World");
            publisher.submit("2019");
            publisher.submit("exception");
            publisher.submit("exit");
            publisher.submit("zhang");
            publisher.submit("1990");
            ExecutorService executorService = (ExecutorService) publisher.getExecutor();
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        }
    }

    private static void println(Object o) {
        System.out.printf("[线程：%s] - %s\n", Thread.currentThread().getName(), o);
    }

}

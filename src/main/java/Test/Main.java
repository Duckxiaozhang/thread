package Test;

import java.util.concurrent.*;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 模拟任务执行过程
        Thread.sleep(1000);  // 让任务执行一段时间
        return "任务执行完毕";
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建一个线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 创建一个 Callable 任务
        MyCallable myCallable = new MyCallable();

        // 提交任务并获取返回结果
        Future<String> future = executorService.submit(myCallable);

        // 获取线程的返回值
        String result = future.get();  // 阻塞直到任务执行完毕并返回结果

        System.out.println("任务返回的结果是: " + result);

        // 关闭线程池
        executorService.shutdown();
    }
}
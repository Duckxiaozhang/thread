package syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String[] args) {
        //newFixedThreadPool 参数为：线程池的大小
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());

        //关闭线程池
        executorService.shutdown();
    }
}
class MyThread implements Runnable {
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
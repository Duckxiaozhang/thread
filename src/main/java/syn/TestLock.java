package syn;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();

    }
}
class TestLock2 implements Runnable{

    int ticketNums = 10;

    //定义Lock锁
    private final ReentrantLock Lock = new ReentrantLock();



    @Override
    public void run() {
        while (true){

            try{
                Lock.lock();
                if (ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }finally {
                //解锁
                Lock.unlock();
            }

        }
    }
}

/*
这段代码是 ReentrantLock 的标准使用模板，所有用到 ReentrantLock 的场景都遵循这个结构

 1. 定义锁对象（final + private 保证安全性）
private final ReentrantLock lock = new ReentrantLock();

// 2. 业务逻辑中使用锁
try {
    lock.lock(); // 加锁：获取锁，其他线程阻塞
    // 核心业务逻辑（操作共享资源）
} catch (Exception e) {
    // 异常处理
} finally {
    lock.unlock(); // 解锁：必须放finally，确保锁一定释放
}
*/
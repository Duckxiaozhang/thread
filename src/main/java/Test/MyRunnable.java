package Test;
//实现runnable接口，重写run方法，创建Runnable对象，使用Thread类来包装Runnable对象，调用start（）方法启动线程
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("线程启动了");
    }
        public static void main(String[] args) {
            // 创建Runnable对象
            MyRunnable mr = new MyRunnable();
            // 使用Thread类来包装Runnable对象
            Thread t = new Thread(mr);
            t.start();
        }
    }


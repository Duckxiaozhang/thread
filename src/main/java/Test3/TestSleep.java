package Test3;
//模拟网络延时
public class TestSleep implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        while (true){
            if (ticket <= 0){
                break;
            }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口：" + Thread.currentThread().getName() + " 抢到第" + ticket + " 张票，剩余：" + (--ticket) + " 张");
            }
        }
        public static void main(String[] args) {
        TestSleep ticket = new TestSleep();
            new Thread(ticket,"小张").start();
            new Thread(ticket,"小谢").start();
            new Thread(ticket,"小周").start();
        }
    }



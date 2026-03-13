package syn;

public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket Station = new BuyTicket();
        new Thread(Station,"小张").start();
        new Thread(Station,"小李").start();
        new Thread(Station,"小谢").start();
    }
}
class BuyTicket implements Runnable{
    private static int ticketNums = 10;
    boolean flag = true;//外部停止方式
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0){
            flag = false;
            return;
        }
        Thread.sleep(100);

        System.out.println(Thread.currentThread().getName() + "正在买第" + ticketNums-- + "张票");
    }
}
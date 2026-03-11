package Test3;

public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread t1 = new Thread(god);

        t1.setDaemon(true);//默认是false，非守护线程，会等所有线程执行完毕，再结束
        t1.start();

        new Thread(you).start();//用户线程
    }

}
class God implements Runnable{
    public void run(){
        while(true){
            System.out.println("上帝保佑着我");
            }
        }
    }
class You implements Runnable{
    public void run(){
        for (int i = 0; i < 365; i++) {
            System.out.println("学习ing");
            }
            System.out.println("==========停止学习=========");
        }
    }
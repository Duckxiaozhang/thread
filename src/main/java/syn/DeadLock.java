package syn;

public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"红太狼");
        Makeup g2 = new Makeup(1,"美羊羊");

        g1.start();
        g2.start();
    }
}

class Lipstick{}
class Mirror{}
class Makeup extends Thread{

    //需要的资源只有一份，用static
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlname;//选择化妆品的人

    Makeup(int choice,String girlname){
        this.choice=choice;
        this.girlname=girlname;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void makeup() throws InterruptedException {
        if (choice==0){
            synchronized (lipstick){//获得口红的锁
                System.out.println(this.girlname+"获得口红的锁");
                Thread.sleep(1000);


            }
            synchronized (mirror){//获得镜子的锁
                System.out.println(this.girlname+"获得镜子的锁");
        }
    }else {
            synchronized (mirror){//获得口红的锁
                System.out.println(this.girlname+"获得镜子的锁");
                Thread.sleep(2000);


                }
            synchronized (lipstick){//获得镜子的锁
                System.out.println(this.girlname+"获得口红的锁");
            }
        }
    }
}
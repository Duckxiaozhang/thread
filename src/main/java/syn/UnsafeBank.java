package syn;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000,"结婚基金");
        DrawMoney you = new DrawMoney(account,500,"小张");
        DrawMoney girlfrend = new DrawMoney(account,1,"小谢");
        you.start();
        girlfrend.start();

    }
}
class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class DrawMoney extends Thread {
    Account account;
    int drawMoney;
    int nowMoney;

    public DrawMoney(Account account, int drawMoney, String name){
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;


    }
    @Override
    public void run() {
        synchronized (account){
            //判断有没有钱
            if (account.money-drawMoney<0){
                System.out.println(Thread.currentThread().getName()+"取钱失败，余额不足");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.money-=drawMoney;
            nowMoney+=drawMoney;
            System.out.println(account.name+"取钱成功，余额为："+account.money);
            System.out.println(this.getName()+"手里的钱"+nowMoney);        }

    }
}
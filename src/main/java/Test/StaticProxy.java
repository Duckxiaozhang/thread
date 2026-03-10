package Test;
//真实对象和代理对象都要实现同一个接口
//代理对象要持有真实对象
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        new Thread(()-> System.out.println("代理对象执行了")).start();
        new WeddingCompany(new You()).happyMarry();
//        WeddingCompany weddingCompany = new WeddingCompany(you);
//        weddingCompany.happyMarry();
    }
}
interface Marry {
    void happyMarry();
}
//真实角色
class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("我要结婚了");
    }
}
//代理角色
class WeddingCompany implements Marry {
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }
    private void after() {
        System.out.println("结婚之后收尾工作");
    }
    private void before() {
        System.out.println("结婚之前准备材料");
    }
}

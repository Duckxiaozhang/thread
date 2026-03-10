package lamda;

public class TestLamda {

    //静态内部类
    static class Like2 implements ilike {
        @Override
        public void lamda() {
            System.out.println("i like you2");
        }
    }

    public static void main(String[] args) {
        ilike like = new Like();
        like.lamda();

        like = new Like2();
        like.lamda();

        //局部内部类
        class Like3 implements ilike {
            @Override
            public void lamda() {
                System.out.println("i like you3");
            }
        }

        like = new Like3();
        like.lamda();

        //匿名内部类，没有类的名称，必须借助接口或者父类
        like = new ilike() {
            @Override
            public void lamda() {
                System.out.println("i like you4");
            }
        };
        like.lamda();

        //lamda表达式
        like = () -> {
            System.out.println("i like you5");
        };

    }
}
//定义一个函数式接口,函数接口只有一个抽象方法;
//任何接口只有一个抽象方法，那他就是函数式接口
interface ilike {
    void lamda();
}
//实现类
class Like implements ilike {
    @Override
    public void lamda() {
        System.out.println("i like you");
    }
}

package com.zhang;
//继承Thread类，重写run方法
public class MyThread extends  Thread{
    @Override
    public void run() {
        System.out.println("线程在运行。。。。");
    }
        public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}

package chb07.lx.q01;

public class Start {
    public static void main(String[] args) {
        System.out.println("----------------------------");
        System.out.println("使用继承Thread类方式创建线程");
        System.out.println("----------------------------");
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread2.start();
        myThread1.start();


    }
}

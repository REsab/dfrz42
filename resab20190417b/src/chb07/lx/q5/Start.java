package chb07.lx.q5;

public class Start extends Thread {
    public static void main(String[] args) {
        // 实例化两个 runnable
        CureThread r1=new CureThread(10,"    ---->>特殊号",500);
        CureThread r2=new CureThread(30,"普通号",250);
        //new thread
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        // 设置优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
//        启动
        t1.start();
        t2.start();
    }
}

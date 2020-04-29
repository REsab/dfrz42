package chb07.lx.q6.a1;

public class MyRunner implements Runnable {

    int length = 1000;   // 总长度
    int i = 0;  //起点

    @Override
    public void run() {
        synchronized (this) {   //同步锁 ,一个时间只有一个人在跑
            System.out.println(Thread.currentThread().getName() + "号选手拿到接力棒!");

            int len = i + 100;  //这个人的终点

            //开始跑
            while (i < len) {
                i += 10;   //已经跑了了多远
                System.out.println(Thread.currentThread().getName() + "号选手跑了" + i + "米");

                try {
                    Thread.sleep(100);    //
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            i = len;  //设置下一个人的起点


        }


    }
}

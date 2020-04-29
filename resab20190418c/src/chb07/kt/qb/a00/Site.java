package chb07.kt.qb.a00;

import org.w3c.dom.css.Counter;

public class Site implements Runnable {
    int ticketNum = 100;
    int count = 0;


    @Override
    public void run() {

        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            ticketNum--;
            count++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            String msg = "抢到第" + count + "张票,剩余" + ticketNum + "张票!";
            System.out.println(Thread.currentThread().getName() + msg);
        }

    }
}

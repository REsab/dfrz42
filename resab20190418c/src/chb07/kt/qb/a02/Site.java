package chb07.kt.qb.a02;

public class Site implements Runnable {
    int ticketNum = 100000;
    int count = 0;


    @Override
    public void run() {

        while (true) {


            if (sale() == false) {

                break;
            }
        }

    }

    private synchronized boolean sale() {
//        System.out.println(Thread.currentThread().getName() );
        if (ticketNum <= 0) {
            return false;
        }
        ticketNum--;
        count++;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String msg = "抢到第" + count + "张票,剩余" + ticketNum + "张票!";
        System.out.println(Thread.currentThread().getName() + msg);
        return true;
    }
}

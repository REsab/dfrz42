package chb07.lx.q7;

public class Site implements Runnable {
    int ticketNum = 1000  ;
    int count = 0;


    @Override
    public void run() {
        while (true) {
            if (sale() == false) {
                break;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized boolean sale() {

        if (ticketNum <= 0) {
            return false;
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
        return true;
    }
}

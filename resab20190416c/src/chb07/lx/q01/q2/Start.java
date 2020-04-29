package chb07.lx.q01.q2;

public class Start {
    public static void main(String[] args) {

        MyRunnable myRunnable=new MyRunnable();
        Thread mythread = new Thread(myRunnable);
        Thread mythread2 = new Thread(myRunnable);
        mythread.start();
        mythread2.start();

    }

}

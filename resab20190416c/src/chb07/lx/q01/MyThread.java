package chb07.lx.q01;

public class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("你好,来自线程["+currentThread().getName()+"]:"+(i+1));

        }

            }
}

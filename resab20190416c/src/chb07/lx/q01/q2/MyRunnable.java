package chb07.lx.q01.q2;

public class MyRunnable  implements  Runnable{


    @Override
    public void run() {

        for (int i = 0; i < 955; i++) {
                 System.out.println("你好,来自线程["+Thread.currentThread().getName()+"]:"+(i+1));

        }
    }
}

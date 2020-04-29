package chb07.lx.q6.a1;

public class Test {
    public static void main(String[] args) {


        MyRunner run = new MyRunner();


        Thread thread1 = new Thread(run, "1");
        Thread thread2 = new Thread(run, "2");
        Thread thread3 = new Thread(run, "3");
        Thread thread4 = new Thread(run, "4");
        Thread thread5 = new Thread(run, "5");
        Thread thread6 = new Thread(run, "6");
        Thread thread7 = new Thread(run, "7");
        Thread thread8 = new Thread(run, "8");
        Thread thread9 = new Thread(run, "9");
        Thread thread10= new Thread(run, "10");

        //run
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();


        //

        System.out.println("观众加油");


    }
}

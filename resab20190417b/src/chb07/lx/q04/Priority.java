package chb07.lx.q04;

import javax.swing.*;
import java.net.http.HttpRequest;
import java.util.Currency;

public class Priority {


    public static void main(String[] args) {
        Thread thread = new Thread();
        Thread main= Thread.currentThread();

        System.out.println("显示默认优先级");
        System.out.println();
        System.out.println("主线程名:"+main.getName() +",优先级:"+main.getPriority());
        System.out.println("子线程名:"+thread.getName()+",优先级:"+thread.getPriority());

        main.setPriority(10);
        thread.setPriority(1);

        System.out.println("修改优先级");
        System.out.println("主线程名:"+main.getName() +",优先级:"+main.getPriority());
        System.out.println("子线程名:"+thread.getName()+",优先级:"+thread.getPriority());



    }


}

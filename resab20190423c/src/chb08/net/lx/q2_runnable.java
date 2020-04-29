package chb08.net.lx;

import java.io.IOException;
import java.net.Socket;

public class q2_runnable implements Runnable {
    int start = 0;
    int end = 0;
    String ip = null;

    q2_runnable(String ip, int strat, int end) {
        this.ip = ip;
        this.start = strat;
        this.end = end;

    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            try {
                Socket socke = new Socket(ip, i);
                System.out.println(i + "\t\t");
            } catch (IOException e) {
                System.out.println("不能连接" + i + "\t\t");
            }
        }
    }
}

package chb08.net.lx;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class q1 {
    /*
    测试本机0-65535中,哪些端口是开放的,
    哪些是被占用的。每行5个,输出本机被占用的所有端口。
     */
    public static void main(String[] args) {

        int row = 1;
        System.out.println("-----------------------------");
        System.out.println("本机已占用的端口");
        System.out.println("-----------------------------");

        for (int i = 0; i < 65535; i++) {
            try {
                ServerSocket socket = new ServerSocket( i);
                socket.close();
            } catch (IOException e) {
                System.out.print(i + "\t\t");
                row++;
                if (row == 6) {
                    row = 1;
                    System.out.println();
                }
            }

        }


    }
}

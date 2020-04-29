package chb08.net.lx;


import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class q2 {
    //    测试远程某个IP中,哪些端口是开放的,哪些是被占用的。
//    "每行5个,输出被占用的所有端口。
    //端口测试
    public static void main(String[] args) {

        String ip = "gotosz.top";
        List<Integer> list = testHostPort(ip);
        System.out.println("-----------------------------");
        System.out.println(ip + "已被占用的端口号有:");
        int row = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t\t");
            row++;
            if (row == 5) {
                row = 0;
                System.out.println();
            }
        }
    }

    //返回已被占用的端口
    public static List<Integer> testHostPort(String ip) {
        List<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < 65535; i++) {
//        for (int i = 20; i < 26; i++) {
            try {
                Socket socke = new Socket(ip, i);
                list.add(i);
            } catch (IOException e) {
                System.out.println(ip + "的端口" + i + "不能连接");
            }
        }


        return list;


    }

}

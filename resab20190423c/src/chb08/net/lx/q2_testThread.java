package chb08.net.lx;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class q2_testThread {
    //    测试远程某个IP中,哪些端口是开放的,哪些是被占用的。
    //    "每行5个,输出被占用的所有端口。
    public static void main(String[] args) {
        //获取当前时间为开始时间，转换为long型
        long startTime = fromDateStringToLong(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date()));

//        String ip = "gotosz.top";
        String ip = "qq.com";
        List<Integer> list = testHostPort(ip);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }

        //获取当前时间为截止时间，转换为long型
        long stopTime = fromDateStringToLong(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date()));

        //计算时间差,单位毫秒
        long timeSpan = stopTime - startTime;
        System.out.println("用时"+timeSpan);



    }


    public static long fromDateStringToLong(String inVal) {
        Date date = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        try {
            date = inputFormat.parse(inVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    //已被占用的端口
    public static List<Integer> testHostPort(String ip) {
        List<Integer> list = new LinkedList<Integer>();
//        for (int i = 0; i < 600; i++) {
//            String runStr = "" + i;
//            q2_runnable run = new q2_runnable(ip, i * 10, (1 + i) * 10);
//            Thread thread = new Thread(run);
//            thread.start();
//
//        }
        for (int i = 0; i < 65535; i++) {
            String runStr = "" + i;
            q2_runnable run = new q2_runnable(ip, i, i + 1);
            Thread thread = new Thread(run);
            thread.start();

        }

        return list;


    }

}

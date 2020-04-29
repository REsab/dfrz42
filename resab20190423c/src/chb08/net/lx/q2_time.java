package chb08.net.lx;

import java.text.SimpleDateFormat;
import java.util.Date;

public class q2_time {

    public static void main(String[] args) {
        q2_time.time();
    }

    public static void time() {


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

    }
}

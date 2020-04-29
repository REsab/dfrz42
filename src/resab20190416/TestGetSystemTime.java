package resab20190416;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TestGetSystemTime {


    static Date nowTime = null;


    /**
     * @param args
     */
    public static void main(String[] args) {


        // 以下为 Clendar 测试代码
        int yyyy, mm, dd;
        Calendar c = Calendar.getInstance();
        yyyy = c.get(Calendar.YEAR);
        mm = c.get(Calendar.MONTH) + 1;
        dd = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("year = " + yyyy);
        System.out.println("month = " + mm);
        System.out.println("day = " + dd);

        // 1. System.currentTimeMillis() 获取系统时间的代码
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String dateStr1 = ts.toString();
        System.out.println("System.currentTimeMillis() = " + dateStr1);

        // 2. date 为获得系统时间的另外一种方法
        Date date = new Date();
        String dateStr2 = new Timestamp(date.getTime()).toString();
        System.out.println(dateStr2);

        // 得到JAVA运行环境的一些基本属性
        System.getProperties().list(System.out);
    }


}


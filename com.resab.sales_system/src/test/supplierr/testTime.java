package test.supplierr;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testTime {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        System.out.println(date.getTime());
        System.out.println(date);
        System.out.println(sdf.getDateFormatSymbols());
        System.out.println(sdf.get2DigitYearStart());
        System.out.println();
        System.out.println();
    }
}

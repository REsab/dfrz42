package chb07.lx.q7;

import java.util.logging.Logger;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        Site site = new Site();
        Thread user1 = new Thread(site, "桃跑跑---------");
        Thread user2 = new Thread(site, "黄牛党***************");
        Thread user3 = new Thread(site, "抢票软件++++");


        user1.start();
        user2.start();
        user3.start();


    }
}

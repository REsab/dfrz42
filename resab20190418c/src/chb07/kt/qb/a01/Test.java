package chb07.kt.qb.a01;

import java.util.logging.Logger;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());
    public static void main(String[] args) {
        Site site = new Site();
        Thread person1 = new Thread(site, "普通用户");
        Thread person2 = new Thread(site, "黄牛党");
        Thread person3 = new Thread(site, "抢票软件");
        logger.info("");
        person1.start();
        person2.start();
        person3.start();
        logger.info("");

    }
}

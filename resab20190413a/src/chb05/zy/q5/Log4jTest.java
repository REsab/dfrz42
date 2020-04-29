package chb05.zy.q5;

import org.apache.log4j.Logger;


public class Log4jTest {

    private static Logger logger = Logger.getLogger(Log4jTest.class.getName());

    public static void main(String[] args) {
        int[] array = new int[]{20, 40, 99, 38, 58};

        for (int i = 0; i <= array.length; i++)
            try {
                logger.debug("输出:" + array[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.debug("数组下标越界,下标" + i);

                logger.error(e.getMessage());
                e.printStackTrace();

            }

    }
}


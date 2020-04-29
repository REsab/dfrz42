package chb05.zy.q3;

public class ArrayIndexExceptionTest1 {

    public static void main(String[] args) {
        int[] array = new int[]{20, 40, 99, 38, 58};

        for (int i = 0; i <= array.length; i++) {
            try {
                System.out.println(array[i]);

            } catch (ArrayIndexOutOfBoundsException e) {
                //e.printStackTrace();
                System.out.println("数组下标越界,下标" + i);
            }
        }
    }
}

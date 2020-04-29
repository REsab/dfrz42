package chb07.lx.q03;

public class Test {
    public static void main(String[] args) {

        ClimbThread youngMan = new ClimbThread("年轻人", 500, 1);
        ClimbThread oldMan = new ClimbThread("老年1231321人", 1500, 1);

        System.out.println("年轻人以" + youngMan.second + "的速度爬1KM;需要爬[" + (1000 / 100) + "个100米,才会到达,要花" + (1000 / 100 * youngMan.second + "秒"));
        System.out.println("年轻人以" + oldMan.second + "的速度爬1KM;需要爬[" + (1000 / 100) + "个100米,才会到达,要花" + (1000 / 100 * oldMan.second) + "秒");

        System.out.println("开始爬山");
        youngMan.start();
        oldMan.start();


    }
}

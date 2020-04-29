package chb07.lx.q03;

public class ClimbThread extends Thread {
    int num = 100;
    String name;
    int second;
    int million;

    ClimbThread(String name, int second, int million) {
        this.name = name;
        this.second = second;
        this.million = million;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                currentThread().sleep(this.second);
                System.out.println(name + "第" + (i + 1) + "次[" + (second * i) + "~" + (second * (i + 1)) + "]爬了100米!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "爬完了");
    }


}

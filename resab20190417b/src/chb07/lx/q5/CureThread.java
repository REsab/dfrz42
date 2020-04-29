package chb07.lx.q5;


//runner 接口实现
class CureThread implements Runnable{

    private int num;
    private String name;
    private int time;
    //构造函数  初始化数据
    public CureThread(int num, String name, int time) {
        this.num=num;
        this.name=name;
        this.time=time;
    }

  //getter
    public int getNum() {
        return num;
    }
    //重写  run方法
    @Override
    public void run() {
        for (int i = 1; i <= this.num; i++) {   //看病次数
            try {
             //   System.out.println("   看病用时"+ time+"0s");
                Thread.sleep(time*10);   //休眠
            } catch (InterruptedException e) {}
    System.out.println(this.name+":"+i+"病人在看病");   //显示在看病的人
            if(this.name.equals("普通号") && i==10) {   ///   当普通病人是 10 的时候
                try {    System.out.println("       join 发生");
                 //   Thread.sleep(time*10);
                    Thread.currentThread().join(3000);   //当前线程加入进来


                } catch (InterruptedException e) {   //catch
                    e.printStackTrace();   // 输出错误
                }
            }
        }
    }
}

package stu_v5;

/**
 * 相当于数据库
 * 相当于数据库
 * 相当于数据库
 * 定义Student数组arrStu——30个元素，初始化如下数据： 1 张三 男
 * 2 李四 女
 * 3 王五 男
 * <p>
 * 提示：
 * 在DataCenter中创建一个initData()方法初始化数据；
 * 为DataCenter创建无参构造函数，以便实例化时调用调用initData()。
 * 3) 访问层类StudentDao【相当于三层结构中的数据访问层】
 * 只完成对DataCenter类中的学生类数组的增删改查，注意，不能有输入输出；
 * 先实例化DataCenter类的一个对象，作为StudentDao的属性。
 */

public class DataCenter {
    public static void main(String[] args) {
        System.out.println();
    }

    static int num = 30;

    public static Student[] studentsArr;
    public static Manager[] managersArr;
    public static String loginName = null;
    //pulic static 可以全局直接类名访问
    //为什么加 static  ...新的东西  现学 现用

    //构造跟 static的区别

    static {   //静态调用
        initData();
    }

    public   static void initData() {
        readAll();

    }

    public static void readAll() {
        StuIO.read();
        if (studentsArr == null || studentsArr.length == 0) {
            StuIO.init();

        }
        if (managersArr == null || managersArr.length == 0) {
            MgrIO.init();

        }

    }

    public static void writeAll() {

        StuIO.Write();
        MgrIO.Write();

    }

}

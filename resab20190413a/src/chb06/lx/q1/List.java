package chb06.lx.q1;

import org.apache.log4j.helpers.FileWatchdog;

import java.util.ArrayList;

public class List {

    public static void main(String[] args) {

        Penguin penguin1 = new Penguin("欧欧", Penguin.SEX_MALE);
        Penguin penguin2 = new Penguin("亚亚", Penguin.SEX_MALE);
        Penguin penguin4 = new Penguin("菲菲", Penguin.SEX_MALE);
        Penguin penguin3 = new Penguin("美美", Penguin.SEX_MALE);

        //添加到list
        ArrayList<Penguin> penguins = new ArrayList<>();
        penguins.add(penguin1);
        penguins.add(penguin2);
        penguins.add(penguin3);
        penguins.add(3, penguin4);
        //    penguins.add(penguin4);

        System.out.println("一共有" + penguins.size() + "只企鹅.");
        System.out.println("分别是");
        //遍历 list   for i
        for (int i = 0; i < penguins.size(); i++) {
            Penguin penguin = penguins.get(i);   //重新赋值转型
            //    Penguin penguinNew =(Penguin) penguins.get(i);   //重新赋值转型
            System.out.println(penguin.getName() + "\t  " + penguin.getSex());
        }
        System.out.println();
        //删除
        penguins.remove(1);
        penguins.remove(penguin1);   //可对象  可下
        System.out.println("删除2只企鹅后");

        //for each 遍历方法
        for (Penguin obj :
                penguins) {
            System.out.println(obj.toString());
        }
        //删除 美美

        if (penguins.contains(penguin3)) {
            penguins.remove(penguin3);
            System.out.println("美美死了");
        } else {
            System.out.println("集合中不包含" + penguin3);
        }

        if (penguins.contains(penguin3)) {
            penguins.remove(penguin3);
            System.out.println("美美死了");
        } else {
            System.out.println("集合中不包含" + penguin3);
        }


    }


}

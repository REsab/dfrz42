package stu_v5;

import javax.swing.*;
import java.io.*;
import java.util.Date;

public class StuIO {

    public static final String FILE_PATH = "D:/STU.dat";

    //初始化方法
    public static final void init() {
        DataCenter.studentsArr = new Student[100];

        for (int i = 0; i < 3; i++) {
            DataCenter.studentsArr[i] = new Student();
        }
        DataCenter.studentsArr[0].setId(1);
        ;
        DataCenter.studentsArr[0].setName("张三");
        DataCenter.studentsArr[0].setSex("男");

        DataCenter.studentsArr[1].setId(2);
        DataCenter.studentsArr[1].setName("李四");
        DataCenter.studentsArr[1].setSex("女");

        DataCenter.studentsArr[2].setId(3);
        DataCenter.studentsArr[2].setName("王五");
        DataCenter.studentsArr[2].setSex("男");



    }

    ///序列化方法
    public static final void Write() {
        FileOutputStream fileOutputStream = null;   //声明对象
            ObjectOutputStream objectOutputStream = null;

            try {
                fileOutputStream = new FileOutputStream(FILE_PATH);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(DataCenter.studentsArr);


            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //反序列化方法
    public static final void read() {

        if (!new File(FILE_PATH).exists()) {
            return;
        }

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(FILE_PATH);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            if (object != null && object instanceof Student[]) {
                DataCenter.studentsArr = (Student[]) object;
            }


        } catch (FileNotFoundException e) {
            System.out.println("反序列化 失败");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}

package stu_v5;

import javax.swing.*;
import java.io.*;
import java.util.Date;

//序列化  -- 写入文件
//反序列  -- 读出文件
public class MgrIO {


    public static final String FILE_PATH = "D:/MGR.dat";

    //初始化方法
    public static final void init() {
        DataCenter.managersArr = new Manager[100];


        for (int i = 0; i < 3; i++) {
            DataCenter.managersArr[i] = new Manager();
        }
        DataCenter.managersArr[0] = new Manager(1, "admin", "123");
        DataCenter.managersArr[1] = new Manager(2, "user", "123");
        DataCenter.managersArr[2] = new Manager(3, "guest", "123");


    }

    ///序列化方法
    public static final void Write() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(FILE_PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(DataCenter.managersArr);


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
            if (object != null && object instanceof Manager[]) {
                DataCenter.managersArr = (Manager[]) object;
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

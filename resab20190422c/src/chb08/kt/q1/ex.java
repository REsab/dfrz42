package chb08.kt.q1;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class ex {
    public static void main(String[] args) throws IOException {
        String path = "f:";   //声明路径
        File dir = new File(path);   //实例化一个文件对象  java 万物皆对象
        showFileRecursion(dir);    //调用方法

    }

    static void showFileRecursion(File file) throws IOException {

        if (file.isDirectory()) {    //是否目录
            //是目录的时候
            System.out.println(file.getAbsolutePath() + file.getName() + " [目录]");
            File[] files = file.listFiles();    //获取当前目录的列表
            for (int i = 0; i < files.length; i++) {
                //调用自身方法   重新查找目录或文件
                showFileRecursion(files[i]);
            }
        } else {
            //是文件的时候
            System.out.println(file.getAbsolutePath() + file.getName());
        }

    }


}

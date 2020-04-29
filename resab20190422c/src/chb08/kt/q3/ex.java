package chb08.kt.q3;

import java.io.*;

//使用FileInputStream和FileOutputStream复制文本文件
//        关键点：字符串对象的getBytes)方法。
public class ex {

    public static void main(String[] args) throws Exception {
        copy("d://edu.txt", "d://edu2.txt");
    }
    private static void copy(String s, String s1) throws Exception {
        //文件字节流读取
        byte[] bytes = new byte[1024];   //temp   临时存放 txt内容
        FileInputStream fileInputStream = new FileInputStream(s);  //文件读取流
        fileInputStream.read(bytes);    //按这个temp 的临时  取byte数组临时存放
        String txt = new String(bytes);   //转成 string
        System.out.println(txt);         //打印
        fileInputStream.close();        //关闭记事本

        //文件写入
        OutputStream outputStream = new FileOutputStream(s1);   //输出文件流
        for (int x = 0; x < bytes.length; x++) {     //不断输出   循环地一个一个byte 输出
            outputStream.write(bytes[x]);           // writes the bytes   写入到文件
        }
        outputStream.close();              //保存好  关闭记事本


    }
}

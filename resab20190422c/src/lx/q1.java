package lx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class q1 {

    public static void main(String[] args) {

        String fileName = "edu.txt";
        String path = "d:\\";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path + fileName));
            out.write("edu0000131321321310uu");//写入文件内容
            System.out.println("文件创建成功！");
            out.close();   //关闭文件


            //获取文件大小
            File file = new File(path + fileName);
            if (!file.exists() || !file.isFile()) {
                System.out.println("文件不存在");
            } else {

                long size1 = file.length();

                System.out.println("文件大小: " + size1 + "字节");

            }

//
//            if (file.delete()) {
//                System.out.println(file.getName() + " 文件已被删除！");
//            } else {
//                System.out.println("文件删除失败！");
//            }


        } catch (IOException e) {
        }


    }



}

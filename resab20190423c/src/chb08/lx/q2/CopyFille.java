package chb08.lx.q2;

import java.io.*;

public class CopyFille {

    public static void main(String[] args) {

        try {
            String path1 = "D:/";
            String path2 = "D:/demo/";
            String fileName1 = "edu.txt";
            String fileName2 = "edu2.txt";


            //1 创建文件  d://edu.txt
            File file = new File(path1 + fileName1);
            if ((!file.exists()) && (file.createNewFile())) {
                System.out.println("文件" + fileName1 + "创建成功");
            }
            //1 创建文件  d://demo//edu.txt
            File file2 = new File(path2 + fileName2);
            if ((!file2.exists()) && (file2.createNewFile())) {
                System.out.println("文件" + fileName2 + "创建成功");
            }

            //1.1  往文件写入内容
            OutputStream os = new FileOutputStream("D:/edu.txt", true);  //1.11 写入流
            String string = "hello liu lao !!";             // 1.12  要写入的内容
            byte[] bytes = string.getBytes();               //1.13 字节 一个一个字节的存
            os.write(bytes);                                //整个字节数组写入 write 只能传byte 或int

            //2 创建文件夹
            File dir = new File("d:/demo");
            if (!(dir.exists()) && dir.mkdir()) {
                System.out.println("demo生成成功");
            }
            os.close();

            //3 FileInputStream
            InputStream is = new FileInputStream(path1 + fileName1);
            byte[] bytes1 = new byte[9];
            StringBuffer sb = new StringBuffer();
            int len = -1;
            while ((len = is.read(bytes1)) != -1) {
                sb.append(new String(bytes1,0,len));
            }
            System.out.println(sb);
            is.close();

            //4 写入另一个文件
            OutputStream os1=new FileOutputStream(path2+file2,true);
            byte[] bytes2=sb.toString().getBytes();
            os1.write(bytes2);
            os1.close();




        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}


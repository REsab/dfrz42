package chb08.x.q4;

import java.io.*;
/*
文件二进制读取复制一张图片
 */
public class CopyPic {

    public static void main(String[] args) {
        DataInputStream dis = null;
        DataOutputStream out = null;

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("d:/1.png");
            dis = new DataInputStream(fis);
            fos = new FileOutputStream("d:1_copy.png");
            out = new DataOutputStream(fos);

            int temp;
            while ((temp = dis.read()) != -1) {
                out.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (dis != null) { dis.close(); }
                if (out != null) { out.close(); }
                if (fis != null) { fis.close(); }
                if (fos != null ) { fos.close(); }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



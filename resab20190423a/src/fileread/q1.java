package fileread;

import java.io.*;

public class q1 {

    public static void main(String[] args) throws IOException {
        //define
        String path = "d:/pet.template.txt";
        FileReader fr = new FileReader(path);
        FileWriter fw = new FileWriter(path);
        BufferedReader bufr = new BufferedReader(fr);
        BufferedWriter bufw = new BufferedWriter(fw);
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";

        //read
        str = bufr.readLine();
        while (str != null) {
            stringBuffer.append(str);
            System.out.println(str);
            str = bufr.readLine();
        }

        //replace
        stringBuffer.replace(1, 5, "23");

        //wirte


        //使用缓冲区中的方法将数据写入到缓冲区中。
        bufw.write(stringBuffer.toString());

        bufw.close();
        fw.close();


    }
}

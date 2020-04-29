package chb08.kt.q4;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 29,作业6:字符流FileReader读取文本文件并显示
 * chb08.kt.q4使用FileReader读取文本文件
 * 关键点:读取到宇符数组中,之后追加到StringBuffer,
 * 最后再toString().文件名为: d:/edu.txt
 */
public class test {
    public static void main(String[] args) throws IOException {

        FileReader fr;   //声明 一个题目要求的读取
        try {
            fr = new FileReader("d:\\edu.txt");     //赋值 一个文件
            BufferedReader br = new BufferedReader(fr);    //缓冲流  读取
            String s;   //字符串
            while (true) {
                try {
                    if ((s = br.readLine()) == null) break;  //是空 就break
                    System.out.println(s);  //打印
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            fr.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


    }

}


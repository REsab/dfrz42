package chb08.kt.q6;

import java.io.*;

/**
 * 0,作业7:字符流FileWriter写入文本文件并显示.
 * chb08.kt.q6
 * 使用Filewriter向文本文件写数据关键点:
 * write()支持直接写字符串到缓冲区,写完要使用flush()
 * 刷新缓冲区要写的内容为:我热爱我的团队!
 * 文f名%: d:/a.txt要求:每运行一次,在最后追加一行
 */
public class ex {
    public static void main(String[] args) throws IOException {
        //读取
        String pathName = "d://a.txt";    //文件路径
        File file = new File(pathName);   //文件对象
        BufferedReader in = new BufferedReader(new FileReader(pathName));    //字符流缓冲读取区
        String string;  //取出字符
        while ((string = in.readLine()) != null) {
            System.out.println(string);
        }
        in.close();  //关闭缓冲区

        //writer
        FileWriter fileWriter = new FileWriter(file, true);  //写入文件的对象
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);  //写入缓冲区
        String str = "我热爱我的团队!";  //要写 的东西
        String enter = "\n"; // 回车换行
        bufferedWriter.append(str + enter);   //buffer 追加内容
        bufferedWriter.append(str + enter);

        fileWriter.write(bufferedWriter.toString());    //buffer 转 string 写入文件
        bufferedWriter.flush();  //清空缓冲区
        fileWriter.close();     //关闭写文件对象

        System.out.println("追加后-----------");
        //重新读取      0
        BufferedReader in2 = new BufferedReader(new FileReader(pathName));
        String string2;
        while ((string2 = in2.readLine()) != null) {
            System.out.println(string2);
        }
        in.close();

    }


}

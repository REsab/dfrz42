package fileread;

import java.io.*;

public class test {
    public static void main(String[] args) {

        try {
            String path = "d:/pet.template.txt";
            Reader reader = new FileReader(
                    path);
            char ch[] = new char[45];
            StringBuffer buffer = new StringBuffer();
            try {
                int length = reader.read(ch);
                while (length != -1) {
                    buffer.append(ch);
                    length = reader.read();
                }
                String str = " 您好!我的名字是{name},我是一只{type}.我的主人是{master}";
                System.out.println("替换前：" + str);
                str = str.replace("{name}", "欧欧");
                str = str.replace("{type}", "狗狗");
                str = str.replace("{master}", "程沐喆");
                System.out.println("替换后：" + str);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String str = "您好!我的名字是欧欧,我是一只狗狗.我的主人是李伟";
        try {
            FileWriter file = new FileWriter("D:\\cmz\\java\\JavaOOP6.0\\pet.template");
            file.write(str);
            if (null!=file) {
                file.close();
                System.out.println("写入成功");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

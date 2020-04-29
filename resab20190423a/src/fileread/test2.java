package fileread;

import java.io.*;
import java.io.Writer;

public class test2 {

public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reader fr = null;
		Writer fw = null;
		StringBuffer sbf = new StringBuffer();

		try {
			fr = new FileReader("D:\\edu.txt");
			BufferedReader br = new BufferedReader(fr);

			char ch[] = new char[1024];

			int length = br.read(ch);

			while (length != -1) {
				sbf.append(ch);
				length = br.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String tmp = sbf.toString();
		System.out.println("替换前：" + tmp);

		tmp.replace("{name}", "欧欧");
		tmp.replace("{type}", "狗狗");
		tmp.replace("{master}", "李伟");

		try {
			fw = new FileWriter("D:\\edu.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(tmp + "\r\n");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("替换后：" + tmp);

	}}

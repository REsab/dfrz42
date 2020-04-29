package chb08.kt.q6;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("d://a.txt");
            BufferedWriter out = new BufferedWriter(new FileWriter("d://a.txt"));
            out.write("aString1\n");
            out.close();
            out = new BufferedWriter(new FileWriter(file,true));
            out.write("aString2");
            out.close();
            BufferedReader in = new BufferedReader(new FileReader("filename"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println("exception occoured"+ e);
        }
    }
}

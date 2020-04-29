package chb08.kt.q1.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class test2 {
    private  static  String path="f:";
    public static void main(String[] a)throws IOException {
        showDirOrFile(1, new File(path));
    }
    static void showDirOrFile(int indent, File file) throws IOException {

        if (file.isDirectory()) {
            System.out.println(file.getAbsolutePath()+file.getName()+" [目录]");
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++)
                showDirOrFile(indent + 4, files[i]);
        }else{
            System.out.println(file.getAbsolutePath()+file.getName());
        }

    }
}

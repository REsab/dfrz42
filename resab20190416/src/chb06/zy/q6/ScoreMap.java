package chb06.zy.q6;

import java.util.HashMap;

public class ScoreMap {


    public static void main(String[] args) {
        java.util.Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("李四", 70);
        map.put("张三", 80);
        map.put("王二", 90);
        System.out.println("成绩单如下:");
        System.out.println("姓名\t\t\t成绩");

        for (String key :
                map.keySet()) {
            System.out.println(key+"\t\t\t"+map.get(key) );
        }

        map.replace("张三", 100);

        System.out.println("修改后的成绩单如下:");
        System.out.println("姓名\t\t\t成绩");
        for (String key :
                map.keySet()) {
            System.out.println(key+"\t\t\t"+map.get(key) );
        }



    }




}

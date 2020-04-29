package chb06.lx.q2;

import javax.print.attribute.standard.DocumentName;
import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {

    public static void main(String[] args) {
        Dog ououDog = new Dog("雪娜瑞", "欧欧");
        Dog yayaDog = new Dog("拉布拉多", "亚亚");
        Dog meimeiDog = new Dog("雪娜瑞", "美美");
        Dog feifeiDog = new Dog("拉布拉多", "菲菲");

        Map dogMap = new HashMap();

        dogMap.put(ououDog.getName(), ououDog.getStratin());
        dogMap.put(yayaDog.getName(), yayaDog.getStratin());
        dogMap.put(meimeiDog.getName(), meimeiDog.getStratin());
        dogMap.put(feifeiDog.getName(), feifeiDog.getStratin());

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入键名");
        String str = scanner.next();
//        String str = "欧欧";

        if (dogMap.containsKey(str)) {
            System.out.println("Map中存在指定对象,对象信息如下");
//            System.out.println(dogMap.keySet());  //所有key的键   [菲菲, 亚亚, 欧欧, 美美]
//            System.out.println(dogMap.values()); //所有key的值  [拉布拉多, 拉布拉多, 雪娜瑞, 雪娜瑞]
//            System.out.println(dogMap.entrySet());  //所有键值对[菲菲=拉布拉多, 亚亚=拉布拉多, 欧欧=雪娜瑞, 美美=雪娜瑞]
            System.out.println(str + "     " + dogMap.get(str));

        } else {
            System.out.println("Map中不存在该对象");
        }

    }


}

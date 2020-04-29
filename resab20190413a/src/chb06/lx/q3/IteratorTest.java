package chb06.lx.q3;

import chb06.lx.q2.Dog;
import com.sun.mail.imap.protocol.ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class IteratorTest {

    public static void main(String[] args) {

        Penguin penguin1 = new Penguin("欧欧", Penguin.SEX_MALE);
        Penguin penguin2 = new Penguin("亚亚", Penguin.SEX_MALE);
        Penguin penguin4 = new Penguin("菲菲", Penguin.SEX_MALE);
        Penguin penguin3 = new Penguin("美美", Penguin.SEX_MALE);

        //添加到 haspMap
        HashMap hashMap = new HashMap();
        hashMap.put(penguin1.getName(), penguin1.getSex());
        hashMap.put(penguin2.getName(), penguin2.getSex());
        hashMap.put(penguin3.getName(), penguin3.getSex());
        hashMap.put(penguin4.getName(), penguin4.getSex());

        Set keys = hashMap.keySet();
        Iterator iterator = keys.iterator();
        System.out.println("使用Iterator遍历的结果:");
        while (iterator.hasNext()) {

            String key = (String) iterator.next();


            System.out.println(key + "\t\t\t" + hashMap.get(key));


        }

    }
}

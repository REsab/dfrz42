package chb06.lx.q4;

import java.util.*;

public class testPenguin {

    public static void main(String[] args) {

        Penguin penguin1 = new Penguin("欧欧", Penguin.SEX_MALE, 1);
        Penguin penguin2 = new Penguin("亚亚", Penguin.SEX_MALE, 2);
        Penguin penguin4 = new Penguin("菲菲", Penguin.SEX_MALE, 3);
        Penguin penguin3 = new Penguin("美美", Penguin.SEX_MALE, 4);

        Map<Integer, Penguin> penguinMap = new HashMap<Integer, Penguin>();
        penguinMap.put(penguin1.getId(), penguin1);
        penguinMap.put(penguin2.getId(), penguin2);
        penguinMap.put(penguin3.getId(), penguin3);
        penguinMap.put(penguin4.getId(), penguin4);

        System.out.println("使用iterator遍历是,所有企鹅的昵称和性别是:");
        Set<Integer> keys = penguinMap.keySet();
        Iterator<Integer> integerIterator = keys.iterator();

        while (integerIterator.hasNext()) {
            Integer integer = integerIterator.next();
            Penguin penguin = penguinMap.get(integer);
            System.out.println(penguin.getName() + "\t\t\t" + penguin.getSex());
        }

        System.out.println("使用foreach遍历是,所有企鹅的昵称和性别是:");
        Collection<Penguin> collection = penguinMap.values();
        for (Penguin penguin : collection) {         System.out.println(penguin.getName() + "\t\t\t" + penguin.getSex());
            System.out.println(penguin.getName() + "\t\t\t" + penguin.getSex());
        }

        System.out.println("使用entrySet遍历是,所有企鹅的昵称和性别是:");
        Set<Map.Entry<Integer, Penguin>> set = penguinMap.entrySet();
        for (Map.Entry<Integer, Penguin> entry : set) {
            System.out.println(entry.getValue().getName() + "\t\t\t" + entry.getValue().getSex());

        }
    }


}

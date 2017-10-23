package lesson31;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {
    public static void main(String[] args) {


        Map<String, Building> map = new HashMap<>();

        Building building1 = new Building("school..", 5);
        Building building2 = new Building("shop", 2);
        map.put("StringKey1", building1);
        map.put("StringKey2", building2);


        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.get("StringKey1"));
        System.out.println(map.get("OtherKey"));
        map.remove("StringKey2");
        System.out.println(map);


    }


}

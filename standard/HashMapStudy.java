package standard;

import java.util.HashMap;

public class HashMapStudy {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("wonseok",1);
        System.out.println(map.size());
        map.put("wonseok", map.get("wonseok") - 1);
        System.out.println(map.size());
    }
}

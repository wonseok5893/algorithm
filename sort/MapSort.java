package com.wonseok.sort;


import java.util.*;

public class MapSort{

    public static void main(String[] args){
        Map<Integer, Double> map = new HashMap<Integer, Double>();

        map.put(1, 0.8);
        map.put(2, 0.3);
        map.put(3, 0.6);
        map.put(4, 0.9);
        map.put(5, 0.2);

        List<Integer> keySetList = new ArrayList<>(map.keySet());

        // 오름차순
        System.out.println("------value 오름차순------");
        Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

        for(Integer key : keySetList) {
            System.out.println("key : " + key + " / " + "value : " + map.get(key));
        }

        System.out.println();

        // 내림차순
        System.out.println("------value 내림차순------");
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        for(Integer key : keySetList) {
            System.out.println("key : " + key + " / " + "value : " + map.get(key));
        }
    }
}
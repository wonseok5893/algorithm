package com.wonseok.kakao.level2;

import java.util.ArrayList;

public class Problem1 {
    public static void main(String[] args) {
        solution(2,new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cacheArr = new ArrayList<>();
        if(cacheSize!=0) {
            for (int i = 0; i < cities.length; i++) {
                String city = cities[i].toLowerCase();
                if (i< cacheSize) {
                    cacheArr.add(city);
                    answer += 5;
                } else {
                    boolean result = true;
                    int removePos = -1;
                    for (int j = 0; j < cacheSize; j++) {
                        if (cacheArr.get(j).equals(city)) {
                            removePos = j;
                            result = false;
                            break;
                        }
                    }
                    if (!result) {
                        cacheArr.remove(removePos);
                        answer += 1;
                    } else {
                        cacheArr.remove(0);
                        answer += 5;
                    }
                    cacheArr.add(city);
                }
            }
        }else answer = cities.length*5;
        return answer;
    }

}

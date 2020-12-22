package com.wonseok.kakao.level2;

import java.util.ArrayList;

public class Problem1 {
    public static void main(String[] args) {
        solution(5, new String[]{"SEOUL", "SEOUL", "SEOUL"});
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cacheArr = new ArrayList<>();
        if (cacheSize != 0) {
            for (int i = 0; i < cities.length; i++) {
                String city = cities[i].toLowerCase();
                if (i < cacheSize) {
                    int removePos = check(cacheArr, city);
                    if (removePos != -1) answer += 1;
                    else
                        answer += 5;
                    cacheArr.add(city);
                } else {
                    int removePos = check(cacheArr,  city);
                    if (removePos != -1) {
                        cacheArr.remove(removePos);
                        answer += 1;
                    } else {
                        cacheArr.remove(0);
                        answer += 5;
                    }
                    cacheArr.add(city);
                }
            }
        } else answer = cities.length * 5;
        System.out.println(answer);
        return answer;
    }

    private static int check(ArrayList<String> list, String city) {
        boolean result = true;
        int removePos = -1;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).equals(city)) {
                removePos = j;
                result = false;
                break;
            }
        }
        return removePos;
    }


}

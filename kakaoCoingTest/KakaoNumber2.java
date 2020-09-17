package com.wonseok.kakaoCoingTest;

import java.util.*;

public class KakaoNumber2 {
    static ArrayList<String> possible = new ArrayList<>();
    static String result = "";
    static Map<String, Integer> resultMap = new HashMap<>();
    static boolean[] visited = new boolean[100001];
    static Map<String, ArrayList<Integer>> menus = new HashMap<>();
    static String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        solution(orders, new int[]{2, 3, 4});
    }

    public static String[] solution(String[] orders, int[] course) {
        //초기화
        int pos = 0;
        for (String s : arr) {
            menus.put(s, new ArrayList<>());
        }
        for (String order : orders) {
            String[] orderMenu = order.split("");
            for (String menu : orderMenu) {
                menus.get(menu).add(pos);
            }
            pos++;
        }


        for (int i = 0; i < course.length; i++) {
            combination(arr, 0, arr.length, course[i]);
            result = "";
        }
        for (String s : possible) {
            String[] str = s.split("");
            resultMap.put(s, likemembers(str));
        }
        List<String> keySetList = new ArrayList<String>(resultMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> resultMap.get(o2).compareTo(resultMap.get(o1)));

        int pos2 = 0;
        List<String> answer = new ArrayList<>();
        int temp = 0;
        int count = 0;
        for (String s : keySetList) {
            if (temp != resultMap.get(s) && count == 0) {
                answer.add(s) ;
                temp = resultMap.get(s);
                count++;
            } else {
                if (temp != resultMap.get(s)) break;
                else answer.add(s);

            }
        }
        return answer.toArray(new String[answer.size()]);
    }

    private static void combination(String[] arr, int index, int length, int count) {
        if (count == 0) {
            possible.add(result);
            return;
        }
        for (int i = index; i < length; i++) {
            if (menus.get(arr[i]).size() > 0) {
                result += arr[i];
                combination(arr, i + 1, length, count - 1);
                result = result.substring(0, result.length() - 1);
            }
        }
    }


    private static int likemembers(String[] items) {
        Set<Integer> likeMembers = new HashSet<>();
        for (String menu : items) {
            for (Integer memberNumber : menus.get(menu)) {
                likeMembers.add(memberNumber);
            }
        }
        return likeMembers.size();

    }

}

package com.wonseok.kakao.kakao2021;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        new Problem2().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}
                , new int[]{2, 3, 4});
        new Problem2().solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}
                , new int[]{2, 3, 5});
        new Problem2().solution(new String[]{"XYZ", "XWY", "WXA"}
                , new int[]{2, 3, 4});
    }

    static Map<String, Integer> map = new HashMap<>();
    static int[] visited;
    static String[] tempOrders;

    public String[] solution(String[] orders, int[] course) {
        tempOrders = orders;
        Set<Character> set = new HashSet<>();
        for (String order : orders) {
            Arrays.stream(order.split("")).forEach(e -> set.add(e.charAt(0)));
        }
        ArrayList<Character> lists = new ArrayList<>(set);
        ArrayList<String> ans = new ArrayList<>();
        for (int e : course) {
            visited = new int[lists.size()];
            combination(lists, -1, e, "");
            ans.addAll(getMaxOrders());
            map.clear();
        }
        Collections.sort(ans);
        String[] ansArr = new String[ans.size()];
        int pos = 0;
        for (String an : ans) {
            ansArr[pos++] = an;
        }
        return ansArr;
    }

    private ArrayList<String> getMaxOrders() {
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        ArrayList<String> ans = new ArrayList<>();
        if (!keys.isEmpty()) {
            keys.sort((a, b) -> map.get(b) - map.get(a));
            int maxValue = map.get(keys.get(0));
            ans.add(keys.get(0));
            for (int i = 1; i < keys.size(); i++) {
                if (map.get(keys.get(i)) == maxValue) ans.add(keys.get(i));
                else break;
            }
        }
        return ans;

    }

    private void combination(ArrayList<Character> lists, int start, int count, String res) {
        if (count == 0) {
            int orderCount = getOrderCount(res);
            if (orderCount >= 2)
                map.put(res, orderCount);
            return;
        }
        for (int i = start + 1; i < lists.size(); i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            res += lists.get(i);
            combination(lists, i, count - 1, res);
            res = res.substring(0, res.length() - 1);
            visited[i] = 0;
        }
    }

    private int getOrderCount(String res) {
        int count = 0;

        for (String order : tempOrders) {
            boolean result = true;
            for (char c : res.toCharArray()) {
                if (order.indexOf(c) == -1) {
                    result = false;
                    break;
                }
            }
            if (result) count++;
        }
        return count;
    }
}

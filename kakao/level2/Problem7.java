package com.wonseok.kakao.level2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem7 {
    public static void main(String[] args) {
        //yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear
        int solution = new Problem7().solution(new String[][]{{"a", "b"}, {"c", "d"}, {"e", "b"}});
        System.out.println(solution);
    }
    public static int[][]dp = new int[31][31];
    public int solution(String[][] clothes) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            if(map.get(clothe[1])==null){
                ArrayList<String> list = new ArrayList<>();
                list.add(clothe[0]);
                map.put(clothe[1],list);
            }else{
                map.get(clothe[1]).add(clothe[0]);
            }
        }
        int count = 1;
        for (String s : map.keySet()) {
            count*=map.get(s).size()+1;
        }

        return count-1;
    }
    public int combination(int n, int r) {
        if(n == r || r == 0)
            return 1;
        else if(dp[n][r]!=0)return dp[n][r];
        else
            return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}

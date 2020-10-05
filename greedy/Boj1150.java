package com.wonseok.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj1150 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[info[0]];
        for (int i = 0; i < info[0]; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            dist.put(i, arr[i + 1] - arr[i]);
        }
        // 초기화
        List<Map.Entry<Integer, Integer>> collect = dist.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        List<Integer> temp = new ArrayList<>();
        int result = 0;
        int pos = 0;
        while (temp.size()!=info[1]) {
            if (pos == 0) {
                result += collect.get(pos).getValue();
                temp.add(collect.get(pos).getKey());
                pos++;
                continue;
            }
            if (true) {
                boolean res = true;
                for (Integer integer : temp) {
                    if (integer + 1 == collect.get(pos).getKey()
                            || integer - 1 == collect.get(pos).getKey()) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    result += collect.get(pos).getValue();
                    temp.add(collect.get(pos).getKey());
                    pos++;
                    continue;
                }
                pos++;
                continue;
            }
        }
        temp = new ArrayList<>();
        pos =1;
        int result1 = 0;
        while (temp.size()!=info[1]) {
            if (true) {
                boolean res = true;
                for (Integer integer : temp) {
                    if (integer + 1 == collect.get(pos).getKey()
                            || integer - 1 == collect.get(pos).getKey()) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    result1 += collect.get(pos).getValue();
                    temp.add(collect.get(pos).getKey());
                    pos++;
                    continue;
                }
                pos++;
                continue;
            }
        }

        System.out.println(result-result1<0?result:result1);


    }
}

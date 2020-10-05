package com.wonseok.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers42586 {
    public static void main(String[] args) {
        int[] arr = {93, 30, 55};
        int[] arr1 = {1, 30, 5};
        int[] solution = solution(arr, arr1);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] stock = Arrays.stream(progresses).map(o -> 100 - o)
                .toArray();
        for (int i = 0; i < stock.length; i++) {
            if (stock[i] % speeds[i] == 0) stock[i] = stock[i] / speeds[i];
            else stock[i] = stock[i] / speeds[i] + 1;
        }

        List<Integer> arr = new ArrayList<>();
        int count = 0;
        int temp = 99999999;
        for (int i = 0; i <stock.length; i++) {
            if(temp>=stock[i]){
                if(count==0) temp = stock[i];
                count++;
            }else {
                arr.add(count);
                count = 1;
                temp= stock[i];
            }
            if(i==stock.length-1&&count!=0){
                arr.add(count);
            }
        }
        return Arrays.stream(arr.toArray(new Integer[arr.size()]))
                .mapToInt(Integer::intValue).toArray();


    }
}

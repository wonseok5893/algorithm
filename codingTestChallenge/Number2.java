package com.wonseok.codingTestChallenge;

import java.util.ArrayList;
import java.util.List;

public class Number2 {
    public static void main(String[] args) {
        solution(6);
    }

    public static int[] solution(int n) {

        int direction = 0;

        int pos = 0;
        int time = n;

        int count = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= (n + 1) * n / 2; i++) {
            count++;
            if (i == 1) {
                direction = 1;
            }

            if (0 < time) {
                graph.get(pos).add(i);
                pos+=direction;
                System.out.println(graph.toString());
            }
            if (count == time) {
                count = 0;
                time--;
                pos-=direction;
                direction = changeDirection(direction);
                pos+=direction;
            }
        }

        for(int i=2;i<graph.size();i++){
            int removeInteger = graph.get(i).get(1);
            graph.get(i).remove(1);
            graph.get(i).add(removeInteger);
        }
        int pos1 =0;
        int [] result = new int[graph.size()];
        for (List<Integer> arr :graph){
            for (Integer e : arr) {
                result[pos1] = e;
                System.out.println(e);
            }

        }

        return result;
    }

    private static int changeDirection(int i) {
        if (i == 1) return 0;
        else if (i == 0) return -1;
        else if (i == -1) return 1;
        else return 0;
    }

}

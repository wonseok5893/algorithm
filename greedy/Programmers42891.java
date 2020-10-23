package com.wonseok.greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers42891 {
    //무지의 먹방 라이브
    public static void main(String[] args) {
        solution(new int[]{3, 1, 2}, 5);
    }

    private static int solution(int[] food_times, long k) {
        long sum = 0;
        for (int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        if (sum <= k) return -1;

        PriorityQueue<Food> queue = new PriorityQueue<Food>();
        int pos = 1;
        for (int e : food_times) {
            queue.offer(new Food(e, pos));
            pos++;
        }
        int previous = 0;

        while (true) {
            Food minFood = queue.peek();
            int length = queue.size();
            int height = minFood.time;

            if (k <= length * (height-previous))
                break;
            k -= length*(height-previous);
            queue.poll();
            previous = height;
        }
        long idx =0;
        idx = k%queue.size();
        ArrayList<Food> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Food poll = queue.poll();
            list.add(poll);
        }

        Collections.sort(list,(o1, o2) -> o1.num-o2.num);
        return list.get((int) idx).num;

    }


    private static class Food implements Comparable<Food> {
        int time;
        int num;

        public Food(int time, int num) {
            this.time = time;
            this.num = num;
        }

        @Override
        public int compareTo(Food o) {
            return time - o.time;
        }
    }
}

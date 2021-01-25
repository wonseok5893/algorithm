package com.wonseok.kakao.level2;

import java.util.PriorityQueue;

public class Level2Problem1 {
    public static void main(String[] args) {

    }
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int e: scoville){
            queue.offer(Long.valueOf(e));
        }
        int count = 0;
        while(queue.size()>=2&&queue.peek()<K){
            Long poll1 = queue.poll();
            Long poll2 = queue.poll();
            Long mix = poll1+2*poll2;
            queue.offer(mix);
            count++;
        }
        if(queue.poll()<K) return -1;
        return count;
    }
}

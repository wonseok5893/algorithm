package com.wonseok.queue;

public class ProgrammersTruck {
    public static void main(String[] args) {
        //https://programmers.co.kr/learn/courses/30/lessons/42583?language=java
        // 다리를 지나는 트럭
        solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10});
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int count = 0;
        int truckWeights = 0;
        int pos =0;

        int[] startTime =new int[truck_weights.length];
        while(count<truck_weights.length){
            time++;
            if(startTime[count]+bridge_length==time){
                truckWeights-= truck_weights[count];
                count++;
            }
            if(pos<truck_weights.length){
                if(truckWeights+truck_weights[pos]<=weight) {
                    truckWeights+=truck_weights[pos];
                    startTime[pos] = time;
                    pos++;
                }
            }
        }

        return time;

    }
}

package ProgrammersTest.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        new 다리를지나는트럭().solution(2, 10, new int[]{7, 4, 5, 6});
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int count = 0;
        int truckWeights = 0;
        int frontTruckPos = 0;

        int[] times = new int[truck_weights.length];
        Arrays.fill(times,bridge_length);

        ArrayList<Integer> nowOnBridgeTrucks = new ArrayList<>();

        while (times[truck_weights.length-1]!=0) {
            time++;
            // 옮기는 과정
            for (int truckPos : nowOnBridgeTrucks) {
                times[truckPos]--;
            }
            // 빠져나갈수 있는 트럭을 제거
            if(times[frontTruckPos]==0){
                truckWeights -= truck_weights[frontTruckPos++];
                nowOnBridgeTrucks.remove(0);
            }
            // 되면 다리 위에 올려
            if(count<truck_weights.length) {
                if (truckWeights + truck_weights[count] <= weight) {
                    truckWeights += truck_weights[count];
                    nowOnBridgeTrucks.add(count++);
                }
            }
        }

        return time;
    }
}

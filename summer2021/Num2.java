package summer2021;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Num2 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] t, int[] r) {
        //t[0] = 0번이 id /  값이 리프트 번호  리프트 번호가 작을수록 우선순위가 높다
        //r[i] = id = i 이고 티켓 등급; r의 값이 작을수록 우선순위가 높다
        PriorityQueue<int[]> readyQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] > o2[2]) return 1;
            else if (o1[2] == o2[2]) {
                if (o1[1] > o2[1]) return 1;
                else if (o1[1] == o2[1]) {
                    if (o1[0] > o2[0]) return 1;
                }
                return 0;
            }
            return -1;
        });
        // id, t, r
        int liftNum = 0;
        int n = t.length;
        int[] ans = new int[n];
        int ansPos = 0;
        while (liftNum <= 10000 ) {
            for (int i = 0; i < n; i++) {
                if (t[i] == liftNum) readyQueue.offer(new int[]{i, t[i], r[i]});
            }
            if (!readyQueue.isEmpty()) {
                ans[ansPos] = readyQueue.poll()[0];
                ansPos++;
            }
            liftNum++;
        }
        return ans;
    }
}

package binarysearch;

import java.util.Arrays;

public class 프로그래머스_징검다리 {

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int start = 1;
        int end = distance;
        int max = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            int before = 0;
            int min = Integer.MAX_VALUE;
            for (int rock : rocks) {
                if (rock - before <= mid)
                    cnt++;
                else {
                    min = Math.min(rock - before, min);
                    before = rock;
                }
            }
            if (distance - before <= mid) cnt++;
            else min = Math.min(distance - before, min);
            if (cnt <= n) {
                max = Math.max(min, max);
                start = mid + 1;
            } else end = mid - 1;
        }
        return max;
    }

}

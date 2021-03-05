package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2230 {

    public static void main(String[] args) throws IOException {
        // 수열 A[1],A[2],...,A[n]
        // 두 수를 골랐을 때, 그 차이가 M이상이면서 제일 작은 경우
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
//        int[] distance = new int[n - 1];
//        for (int i = 0; i < n - 1; i++) {
//            distance[i] = arr[i + 1] - arr[i];
//        }
//
//        int min = twoPointer(n, m, distance);
//        System.out.println(min);

        int ans2 = (int) 2e9;
        for (int i = 0; i < n; i++) {
            int expectedEnd = m + arr[i];
            int minIdx = lowerBound(0, n - 1, expectedEnd, arr);
            if (arr[minIdx] - arr[i] >= m)
                ans2 = Math.min(ans2, arr[minIdx] - arr[i]);
        }
        System.out.println(ans2);
    }

    private static int lowerBound(int start, int end, int value, int[] arr) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private static int twoPointer(int n, int m, int[] distance) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = (int) 2e9;
        while (start <= end) {
            if (sum >= m) {
                min = Math.min(min, sum);
                sum -= distance[start++];
            } else if (end >= n - 1) break;
            else {
                sum += distance[end++];
            }
        }
        return min;
    }

}

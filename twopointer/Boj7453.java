package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj7453 {
    static long[]AB;
    static long[]CD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[][] arr = new long[4][n];

        int pos = 0;
        while(pos<n) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                arr[j][pos] = Long.valueOf(st.nextToken());
            }
            pos++;
        }
        AB = new long[n*n];
        CD = new long[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx++] = arr[0][i] + arr[1][j];
            }
        }
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                CD[idx++] = arr[2][i] + arr[3][j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        solutionBinarySearch(n, arr);
    }

    private static void solutionBinarySearch(int n, long[][] arr) {

        // 160,000 AB
        // 160,000 CD
        // -> 이분탐색 NlogN
        long sum = 0;
        for (long target : AB) {
            int upperIdx = upperBound(-target);
            int lowerIdx = lowerBound(-target);
            if (upperIdx == -1) continue;
            sum += (upperIdx - lowerIdx) + 1;
        }
        System.out.println(sum);
    }

    private static int upperBound(long target) {
        int start = 0;
        int end = CD.length-1;
        int ans = -1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(CD[mid]>target){
                end = mid-1;
            }else{
                if(CD[mid]==target) ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }

    private static int lowerBound(long target) {
        int start = 0;
        int end = CD.length-1;
        int ans = -1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(CD[mid]<target){
                start = mid+1;
            }else{
                if(CD[mid]==target) ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}

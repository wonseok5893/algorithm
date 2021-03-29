package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj10816 {
    public static void main(String[] args) throws IOException {
        // 정수가 적힌 숫자 카드 N개
        // 정수 M개가 주어졌을때 몇개 가지고 있는지 출력
        // N<= 500,000
        // M<= 500,000
        // O(N*M) -> 시간초과
        // O(M log N) -> 이분탐색

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int m = Integer.parseInt(br.readLine());
        int[] mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(nArr);
        StringBuffer sb = new StringBuffer();
        for (int findNum : mArr) {
            int uIdx = upperBound(nArr, findNum);
            int lIdx = lowerBound(nArr, findNum);
            if(uIdx==-1) sb.append(0+" ");
            else sb.append(uIdx - lIdx + 1+" ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] nArr, int findNum) {
        int start = 0;
        int end = nArr.length-1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(nArr[mid]<findNum){
                start = mid+1;
            }else{
                if(nArr[mid]==findNum){
                    ans = mid;
                }
                end = mid-1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] nArr, int findNum) {
        int start = 0;
        int end = nArr.length-1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(nArr[mid]>findNum){
                end = mid-1;
            }else{
                if(nArr[mid]==findNum){
                    ans = mid;
                }
                start = mid+1;
            }
        }
        return ans;
    }
}

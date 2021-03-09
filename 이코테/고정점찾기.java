package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 고정점찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //오름차순으로 정렬 된 수열이 주어진다.
        // a[i] == i 인 i를 구해라 없으면 -1 출력
        // O(logN)으로 풀어라
        Nsolution(arr);
        LogNsolution(arr);
    }

    private static void LogNsolution(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr[mid]<mid){
                start = mid+1;
            }else{
                if(arr[mid]==mid)ans = mid;
                end = mid -1;
            }
        }
        System.out.println(ans);
    }

    private static void Nsolution(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==i) ans.add(i);
        }
        if(ans.size()==0) System.out.println(-1);
        else System.out.println(ans.get(0));
    }
}

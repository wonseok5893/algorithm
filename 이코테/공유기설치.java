package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        Arrays.sort(arr);
        // 파라메트릭 서치
        int max = arr[arr.length - 1] - arr[0];
        int min = 1;
        while (min <= max) {
            int value = arr[0];
            int mid = (min + max) / 2;
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] >= value + mid) {
                    value = arr[i];
                    count++;
                }
            }
            if (count >= c) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(result);
    }
}

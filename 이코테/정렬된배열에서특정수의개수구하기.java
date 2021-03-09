package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정렬된배열에서특정수의개수구하기 {
    public static void main(String[] args) throws IOException {
        // 오름차순으로 정렬된 수열이 있다.
        //이 수열에서 x가 등장 하는 횟수를 구하시오
        // n 과 x가 주어진다.
        // n<= 1,000,000
        // x 는 int형
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int first = binaryLowerbound(arr, x);
        int second = binaryUpperbound(arr, x);
        System.out.println(first);
        System.out.println(second);
        System.out.println(second - first + 1);

    }

    private static int binaryUpperbound(int[] arr, int find) {
        int start = 0;
        int end = arr.length - 1;
        int answer = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= find) {
                if (arr[mid] == find) answer = mid;
                start = mid + 1;
            } else if (arr[mid] > find) {
                end = mid - 1;
            }
        }
        return answer;
    }

    private static int binaryLowerbound(int[] arr, int find) {
        int start = 0;
        int end = arr.length - 1;
        int answer = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < find) {
                start = mid + 1;
            } else if (arr[mid] >= find) {
                if (arr[mid] == find) answer = mid;
                end = mid - 1;
            }
        }

        return answer;
    }
}

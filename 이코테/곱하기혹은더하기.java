package 이코테;

import java.util.Arrays;

public class 곱하기혹은더하기 {
    public static void main(String[] args) {
        //0~~9로 이루어진 문자열 S
        //숫자 사이에 x 혹은 + 만들수 있는 가장 큰수
        //모든 연산으 왼쪽에서 부터 시작
        String S1 = "02984";
        String S2 = "567";
        solution(S2);
    }

    private static void solution(String s) {
        int[] arr = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //더할지 곱할지
            int ans1 = ans + arr[i];
            int ans2 = ans * arr[i];
            ans = Math.max(ans1, ans2);
        }
        System.out.println(ans);

    }
}

package 이코테;

import java.util.Arrays;

public class 문자열뒤집기 {
    public static void main(String[] args) {
        // 0~1로 이루어진 S
        // S에 있는 모든 숫자를 전부 같게 하려고 한다.
        // 연속된 숫자를 한번에 뒤집을 수 있다.
        // S = 0001100
        // 4번째 묹부터 5번째 문자를 뒤집으면 1111111이 된다

        // S의 길이는 S.length<=1000,000
        // N^2안됨 -> O(n)<=nlogn 정도는 되야 성공
        String s = "00011001101110110";
        solution(s);
    }

    private static void solution(String s) {
        int[] arr = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
        // 모두 1로 바꾸는 경우의수
        int ans1 = 0;
        boolean start = false;
        ans1 = getAns(arr, 1);
        System.out.println(ans1);
        // 모두 0으로 바꾸는 경우의수
        int ans0 = 0;
        ans0 = getAns(arr, 0);
        System.out.println(ans0);

        System.out.println(ans0<ans1?ans0:ans1);
    }

    private static int getAns(int[] arr,  int value) {
        boolean start = false;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(start) {
                if (arr[i] != value) {
                    continue;
                }else{
                    start = false;
                }
            }else{
                if(arr[i] != value) {
                    start = true;
                    ans++;
                }
                continue;
            }
        }
        return ans;
    }
}

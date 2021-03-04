package 이코테;

import java.util.Arrays;
import java.util.Random;

public class 모험가길드 {
    public static void main(String[] args) {
        //한마을에 모험가 N명 / -> 공포도 측정
        // 그룹을 안전하게 만들려고한다
        // 공포도가 X인 모험가는 반드시 X명이상으로 참여해야 여행가능하다

        // 입력값 N : 1<=N<=100,000
        // ex) N = 5 / 2 3 1 2 2
        int k = 100;
        while(k-->0) {
            int n = new Random().nextInt(10)+1;
            int[] arr = makeRandArr(n);
            for (int e : makeRandArr(n)) {
                System.out.print(e + " ");
            }
            System.out.println();
            if(solution(n, arr)!=solution2(n, arr))break;
        }
        //solution은 틀렸다.!
        //답 solution1
    }

    public static int solution(int n ,int[]arr){
        Arrays.sort(arr);
        // 1 2 2 2 3
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int needCount = arr[i];
            if(arr.length-i>=needCount) {
                i += needCount-1;
                count++;
            }else break;
        }
        System.out.println(count);
        return count;
    }
    public static int solution2(int n ,int[]arr){
        Arrays.sort(arr);
        // 1 2 2 2 3
        int count = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if(count>=i) {
                ans++;
                count=0;
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static int[] makeRandArr(int n ){
        Random random = new Random();
        int[] arr = new int[n];
        while(n>0) {
            arr[n-1] = random.nextInt(n)+1;
            n--;
        }
        return arr;
    }
}

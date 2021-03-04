package 이코테;

import java.util.Arrays;

public class 만들수없는금액 {
    public static void main(String[] args) {
        //동빈이는 N개 동전을 가지고있다
        //만들수 없는 금액 중 최솟 값
        //
        // 1<= N <= 1000
        // 화폐단위는 <= 1,000,000

        int n = 5;
        int[] arr = new int[]{3, 2, 1, 1, 9};
        solution(n, arr);

    }

    private static void solution(int n, int[] arr) {
        Arrays.sort(arr);
        int k =1;
        while(k<=(int)1e9){
            //k원을 만들수 있나?
            if (!check(k,arr)) {
                System.out.println(k);
                break;
            }
            k++;
        }
    }

    private static boolean check(int k,int[]arr) {
        int start = 0;
        int end = 0;
        int sum = 0;
        while(start<=end&&end<arr.length){
            if(sum>=k){
                if(sum==k)return true;
                sum-=arr[start++];
            }else{
                sum += arr[end++];
            }
        }
        return false;
    }
}

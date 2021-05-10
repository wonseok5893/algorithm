package math;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            if(checkHansu(i))ans++;
        }
        System.out.println(ans);
    }

    private static boolean checkHansu(int n) {
        int[] arr = Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt).toArray();
        if(arr.length<=2)return true;
        int[] diffArr = new int[arr.length - 1];
        for (int i = 0; i < diffArr.length; i++) {
            diffArr[i] = arr[i + 1] - arr[i];
        }
        for (int i = 1; i <diffArr.length ; i++) {
            if(diffArr[i]!=diffArr[0])return false;
        }
        return true;

    }
}

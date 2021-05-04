package math;

import java.util.Scanner;

public class Boj17427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            ans += (n / i) * i;
        }
        long temp = 0;
        for (int i = 1; i < n; i++) {
            temp += ((n-1) / i) * i;
        }
        System.out.println(ans-temp);
        System.out.println(ans);
    }
}

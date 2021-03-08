package 이코테;

import java.util.Scanner;

public class 럭키스트레이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int sum1 = 0, sum2=0;
        for (int i = 0; i < chars.length; i++) {
            if(i<chars.length/2) sum1 += chars[i] - '0';
            else sum2 += chars[i] - '0';
        }
        if(sum1==sum2) System.out.println("LUCKEY");
        else System.out.println("READY");
    }
}

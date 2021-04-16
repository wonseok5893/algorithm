package bitmasking;

import java.util.Scanner;

public class Boj1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 32;
        int sum = 0;
        if(n==64) System.out.println(1);
        else {
            while (true) {
                sum += (n & len)/len;
                if (len == 1) break;
                len = len >> 1;
            }
            System.out.println(sum);
        }
    }

}

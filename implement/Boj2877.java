package implement;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj2877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        // k번쨰 몇자리수 인지 알아야함
        // k = 14
        // k = 8 14 16
        //    777 9 4444 4447 4474 4477 7777
        int len = 0;
        int num =1;
        int sum = 0;
        while(sum<k){
            num = num<<1;
            sum += num;
            len++;
        }
        sum -= num;
        String start = "";
        for (int i = 0; i < len; i++) {
            start += "4";
        }
        int diff = k-sum;
        if(diff==0) System.out.println(start);
        else{
            --diff;
            char[] chars = start.toCharArray();
            String changeStr = Integer.toBinaryString(diff);
            for (int i = 0; i < changeStr.length(); i++) {
                if (changeStr.charAt(changeStr.length() - 1 - i) == '1') {
                    chars[chars.length - 1 - i] = '7';
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
            }
            System.out.println(sb);
        }
    }
}

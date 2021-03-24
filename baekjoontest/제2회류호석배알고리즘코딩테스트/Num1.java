package baekjoontest.제2회류호석배알고리즘코딩테스트;

import java.util.Scanner;

public class Num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        String aStr = str[0];
        String bStr = str[1];

        int possibleStartA = 2;
        int possibleStartB = 2;

        char[] aChar = aStr.toCharArray();
        char[] bChar = bStr.toCharArray();

        possibleStartA = Math.max(2,getPossibleStart(aChar));
        possibleStartB = Math.max(2,getPossibleStart(bChar));
        long X= 0;
        int a=0,b=0;
        int count = 0;
        while(true){
            long A = getLongByStr(aChar,possibleStartA);
            long B = getLongByStr(bChar,possibleStartB);
            if(A>=B) {
                if(A==B&&possibleStartA!=possibleStartB){
                    X = A;
                    a = possibleStartA;
                    b = possibleStartB;
                    count++;
                }
                possibleStartB++;
            } else possibleStartA++;
            if(possibleStartA==37)break;
            if(possibleStartB==37)break;
        }
        if(count>1) System.out.println("Multiple");
        else if(count == 1) System.out.println(X+" "+a+" "+b);
        else System.out.println("Impossible");
    }

    private static long getLongByStr(char[] aChar, int possibleStartA) {
        long sum =0;
        for (int i = aChar.length-1; i >=0 ; i--) {
            char c = aChar[i];
            if(Character.isDigit(c)) {
                int num = c - '0';
                sum += num * pow(possibleStartA, aChar.length - 1 - i);
            }
            else{
                int num = c - 'a' + 10;
                sum+=  num * pow(possibleStartA, aChar.length - 1-i);
            }
        }
        return sum;
    }

    private static long pow(int a, int n) {
        long sum = 1;
        for (int i = 0; i < n; i++) {
            sum*=a;
        }
        return sum;
    }

    private static int getPossibleStart(char[] aChar) {
        int max = -1;
        for (char c : aChar) {
            if(Character.isDigit(c))
                max = Math.max(c-'0', max);
            else
                max = Math.max(c - 'a' + 10, max);
        }
        return max+1;
    }
}

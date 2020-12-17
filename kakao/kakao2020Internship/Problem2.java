package kakao.kakao2020Internship;

import java.util.Stack;

public class Problem2 {
    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }

    public static long solution(String expression) {
        String[] numArr = expression.split("\\+|\\-|\\*");
        char[] charArr = expression.toCharArray();
        String[] operArr = new String[numArr.length - 1];

        int pos = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '+' || charArr[i] == '-' || charArr[i] == '*') {
                operArr[pos++] = String.valueOf(charArr[i]);
            }
        }

        int[][]priority = new int[6][3];
        priority[0] = new int[]{0,1,2};
        priority[0] = new int[]{0,2,1};
        priority[0] = new int[]{1,2,0};
        priority[0] = new int[]{1,0,2};
        priority[0] = new int[]{2,0,1};
        priority[0] = new int[]{2,1,0};
        for (int i = 0; i < 6; i++) {
            // + - *
            int[] priority1 = priority[i];

        }

        return 0;
    }


    private static int getPriority(String str, int[] priority) {
        if (str.equals("*")) return priority[2];
        else if (str.equals("+")) return priority[0];
        else return priority[1];
    }
}

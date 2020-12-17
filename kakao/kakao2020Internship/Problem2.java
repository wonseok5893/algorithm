package kakao.kakao2020Internship;

import java.util.Stack;

public class Problem2 {
    public static void main(String[] args) {
        solution("100*200*300-500*20");
    }

    public static long solution(String expression) {
        String[] numArr = expression.split("\\+|\\-|\\*");
        char[] charArr = expression.toCharArray();
        String[] operArr = new String[numArr.length - 1];
        Stack<String> stack = new Stack<>();

        int[][]priority = new int[6][3];
        priority[0] = new int[]{0,1,2};
        priority[1] = new int[]{0,2,1};
        priority[2] = new int[]{1,0,2};
        priority[3] = new int[]{1,2,0};
        priority[4] = new int[]{2,1,0};
        priority[5] = new int[]{2,0,1};
        long max = -1;
        for (int j = 0; j <6 ; j++) {
            int pos = 0;
            String beforeOper = "";
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == '+' || charArr[i] == '-' || charArr[i] == '*') {
                    stack.push(numArr[pos]);
                    if (stack.size()<3||getPriority(String.valueOf(charArr[i]),priority[j])>getPriority(beforeOper,priority[j])||beforeOper.equals(""))
                    {
                        stack.push(String.valueOf(charArr[i]));
                        beforeOper = String.valueOf(charArr[i]);
                    }else{
                        while(stack.size()>=3&&getPriority(String.valueOf(charArr[i]), priority[j]) <= getPriority(beforeOper, priority[j]) && !beforeOper.equals("")) {
                                long num4 = Long.parseLong(stack.pop());
                                String oper2 = stack.pop();
                                long num3 = Long.parseLong(stack.pop());
                                long result2= calculate(num3, num4, oper2);
                                if(stack.size()==0)beforeOper = "";
                                else beforeOper = stack.peek();
                                stack.push(String.valueOf(result2));
                        }
                        stack.push(String.valueOf(charArr[i]));
                    }
                    pos++;
                }
            }
            stack.push(numArr[pos]);
            while (stack.size()>1){
                long num2 = Long.parseLong(stack.pop());
                String oper = stack.pop();
                long num1 = Long.parseLong(stack.pop());
                long result =calculate(num1, num2, oper);
                stack.push(String.valueOf(result));
            }
            long ans = Long.parseLong(stack.pop());
            System.out.println(ans);
            if(ans<0) ans *=-1;
            max = Math.max(max,ans);
        }

        return max;
    }

    private static long calculate(long num1, long num2, String oper) {
        switch (oper){
            case "*":{
                return num1*num2;
            }
            case "+":{
                return num1+num2;
            }
            case "-":{
                return num1-num2;
            }
        }
        return 0;
    }


    private static int getPriority(String str, int[] priority) {
        if (str.equals("*")) return priority[2];
        else if (str.equals("+")) return priority[0];
        else return priority[1];
    }
}

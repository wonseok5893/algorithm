package kakao.kakao2020Internship;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Problem2_2 {
    public static void main(String[] args) {
        solution("100*200*300-500*20");
    }
    public static long solution(String expression) {
        String[] arr= new String[6];
        arr[0] = "*+-";
        arr[1] = "*-+";
        arr[2] = "+*-";
        arr[3] = "+-*";
        arr[4] = "-*+";
        arr[5] = "-+*";
        int max = -1;
        String[] numArr = expression.split("\\+|\\-|\\*");
        Stack<String> stack = new Stack<>();
        String copyExp = expression;
        for (int j = 0; j < arr.length; j++) {
            String s = arr[j];
            for (int i = 0; i < 3; i++) {
                //3번하면됨
                copyExp = calc(copyExp,s.charAt(i));
                max = Math.max(max,getMax(copyExp));
                }
            }

        System.out.println(max);
        return max;
    }

    private static int getMax(String copyExp) {
        int e = Integer.parseInt(copyExp);
        if(e<0)return e*-1;
        return e;
    }

    private static String calc(String copyExp, char c) {
        int pos = 0;

        String[] numArr = copyExp.split("\\+|\\-|\\*");
        LinkedList<Integer> list = new LinkedList<>();
        for (String s : numArr) {
            list.add(Integer.parseInt(s));
        }
        ArrayList<String> operList = new ArrayList<>();
        int count = 0;
        while(pos<copyExp.length()){
            char k = copyExp.charAt(pos);
            if(!Character.isDigit(k)){
                if(k==c){
                    int a = list.get(count);
                    int b = list.get(count+1);
                    int sum = get(a,b,k);
                    list.remove(count);
                    list.remove(count);
                    list.add(count,sum);
                }
                else operList.add(String.valueOf(k));
            }
            pos++;
        }
        String result = String.valueOf(list.get(0));
        for (int i = 0; i < operList.size(); i++) {
            String s = operList.get(i);
            int num = list.get(i);
            result+=s;
            result+=num;
        }
        return result;
    }

    private static int get(int a, int b, char k) {
        if(k=='*')return a*b;
        if(k=='+')return a+b;
        if(k=='-')return a-b;
        return -1;
    }
}

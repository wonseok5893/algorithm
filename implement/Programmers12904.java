package com.wonseok.implement;

public class Programmers12904 {
    public static void main(String[] args) {
        //가장 긴 팰린드롬 길이 구하기


    }

    public int solution(String s) {
        int max = 1;
        int length = s.length();
        for (int i = 0; i < length-1; i++) {
            int pos = 1;
            int count = 1;
            //abvba
            while (i - pos >= 0 && i + pos < length) {
                if (s.charAt(i - pos) == s.charAt(i + pos)) {
                    count+=2;
                    pos++;
                }else break;
            }
            if(max<count) max = count;
            //abba
            int incre=1;
            int count2 = 0;
            if(s.charAt(i)==s.charAt(i+1)){
                count2 = 2;
                while(i+1+incre<length&&i-incre>=0){
                    if (s.charAt(i - incre) == s.charAt(i+1 + incre)) {
                        count2+=2;
                        incre++;
                    }else break;
                }
            }
            if(max<count2) max = count2;

        }
        return max;
    }


}

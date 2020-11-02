package com.wonseok.implement;

import java.util.ArrayList;

public class Programmers202827 {
    public static void main(String[] args) {

    }
    public String solution(String sentence) {
        ArrayList<Alpha> list = new ArrayList<>();
        //SpIpGpOpNpGJqOqA
        char temp = 'A';
        for (int i = 0; i < sentence.length(); i++) {
            char start = sentence.charAt(i);
            if(Character.isLowerCase(start)
            &&temp!=start){
                list.add(new Alpha(1));
            }
        }
        return "";
    }

    private class Alpha {
        int startIdx;
        int count;
        int endIdx;
        public Alpha(int idx) {
            this.startIdx = idx;
            this.count = 1;
        }
    }
}

package com.wonseok.codingTestChallenge;

import java.util.ArrayList;
import java.util.List;

// [-16,27,65,-2,58,-92,-71,-68,-61,-33]	6//
public class Number3 {
    public static void main(String[] args) {
        int[] arr = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        solution(arr);
    }
    public static int solution(int[] a) {

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<a.length;i++){
            boolean chance = true;
            int targetIndex = i;
            if(possibleCheck(targetIndex)) result.add(a[targetIndex]);
        }
        return result.size();


    }

    private static boolean possibleCheck(int targetIndex) {
    return true;
    }

}

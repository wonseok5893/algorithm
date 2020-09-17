package com.wonseok.codingTestChallenge;

import org.omg.CORBA.ARG_IN;

import java.util.*;

public class Number1 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1};
        solution(arr);
    }


    public static int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        Set<Integer> result = new HashSet<Integer>() {
        };
        int tempFirst = -1;
        int tempSecond = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (tempFirst == numbers[i]) {
                continue;
            }else tempFirst = numbers[i];
            for (int j = i+1; j < numbers.length; j++) {
                tempSecond = -1;
                if(tempSecond == numbers[j]) continue;
                else {
                    tempSecond = numbers[j];
                    result.add(tempFirst+tempSecond);
                }
            }
        }
        int pos = 0;
        int[] arrayResult = new int[result.size()];
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            arrayResult[pos] = iterator.next();
            pos++;
        }
        return arrayResult;

    }

}

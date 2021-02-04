package com.wonseok.kakao.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class N개의최소공배수Test {
    @Test
    void 최소공배수_테스트(){
        Random random = new Random();
        boolean result =true;
        N개의최소공배수 instance = new N개의최소공배수();
        while(result) {
            for (int i = 15; i <= 15; i++) {
                int[] randArr = makeRandomIntArray(random, i);
                int solution = instance.solution(randArr);
                int solution1 = instance.solution1(randArr);
                System.out.println(Arrays.stream(randArr).reduce((a,e)->a*e).getAsInt());
                System.out.println(solution+" "+solution1);
                for (int e : randArr) {
                    System.out.print(e+" ");
                }
                System.out.println();
                if(solution != solution1){
                    result = false;
                    break;
                }
            }
        }
        assertEquals(result,true);
    }

    private int[] makeRandomIntArray(Random random, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100)+1;
        }
        return arr;
    }

    // A B C D
    // [A,B] = G // GAB
    // [G,C] = G2 // G2GC
    // [G2,D] = G3 // G3G2D





    boolean fianlCheck = false;

    void dfs(int max, int count, int[] arr) {

        if(fianlCheck) return;

        int num = max*count;
        boolean check = true;
        for(int i=0;i<arr.length;i++) {
            if(num%arr[i]!=0) {
                check = false;
                break;
            }
        }
        if(check) {
            fianlCheck = true;
            return;
        } else {
            dfs(max, count+1, arr);
        }

    }


}
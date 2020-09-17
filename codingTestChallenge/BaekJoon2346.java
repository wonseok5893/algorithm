package com.wonseok.codingTestChallenge;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 풍선터뜨리기 문제
/* 풍선의 위치가 변하기 떄문에 따로 객체를 만들어 저장
    arrayList 삭제는 오른쪽에서 왼쪽으로
*/

public class BaekJoon2346 {

    static List<Balloon> balloons = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int key1 = 1;
        for (int v : values) {
            balloons.add(new Balloon(key1++, v));
        }
        int deletIndex = 0;
        while (!balloons.isEmpty()) {
            int next = balloons.get(deletIndex).getValue();
            System.out.print(balloons.get(deletIndex).getKey() + " ");
            balloons.remove(deletIndex);
            if (next > 0) deletIndex -= 1;
            deletIndex += next;
            if (balloons.size() == 0) return;
            if (balloons.size() == 1) deletIndex = 0;

            if (deletIndex > balloons.size())
                deletIndex %= (balloons.size());

            while (deletIndex < 0) {
                deletIndex += balloons.size();
            }
        }

    }


    static class Balloon {
        int key;
        int value;

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public Balloon(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

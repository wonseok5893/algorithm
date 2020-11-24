package com.wonseok.implement;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16236 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        Fish baby;
        ArrayList<Fish> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (9 > num && num > 0)
                    list.add(new Fish(j,i,num));
                if(num==9) baby = new Fish(j,i,num);
                    map[i][j] = num;
            }
        }
        /// 초기화
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};


    }

    private static class Fish {
        int x;
        int y;
        int size;
        int distance;

        public Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
}

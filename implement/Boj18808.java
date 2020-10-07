package com.wonseok.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj18808 {
    static StringTokenizer st;
    static int[][] graph;
    static int[][] temp;
    static int n;
    static int m;
    static int turn;
    static List<int[][]> stickers = new ArrayList<int[][]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        temp = new int[n][m];


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int tempSticker[][] = new int[y][x];
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int l = 0; l < x; l++) {
                    tempSticker[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(tempSticker);
        }

        for (int[][] sticker : stickers) {
            turn = 0;
            while(true) {
                if (!sizeCheck(sticker)) {
                    sticker = rotate(sticker);
                }else {
                    if (!possibleCheck(sticker))
                        sticker = rotate(sticker);
                    else break;
                }
                if(turn==4)break;
            }
        }
        int count = 0;
        for (int[] ints : graph) {
            for (int e : ints) {
                if(e==1)count++;
            }
        }
        System.out.println(count);

    }

    private static boolean possibleCheck(int[][] sticker) {
        int y = sticker.length;
        int x = sticker[0].length;
        for (int i = 0; i <= n - y; i++) {
            for (int j = 0; j <= m - x; j++) {
                int startY = i;
                int startX = j;
                boolean result = true;
                loop:
                for (int k = 0; k < y; k++) {
                    for (int l = 0; l < x; l++) {
                        if (sticker[k][l] == 1) {
                            if (temp[startY + k][startX + l] != 0) {
                                result = false;
                                break loop;
                            }else{
                                temp[startY+k][startX+l] = 1;
                            }
                        }
                    }
                }
                if(result) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            graph[k][l] = temp[k][l];
                        }
                    }
                  return true;
                }else{
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            temp[k][l] = graph[k][l];
                        }
                    }
                }
            }
        }
        return false;
    }

    private static int[][] rotate(int[][] sticker) {
        int y = sticker.length;
        int x = sticker[0].length;
        int[][] rotate = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                rotate[i][j] = sticker[y - 1 - j][i];
            }
        }
        turn++;
        return rotate;
    }

    private static boolean sizeCheck(int[][] sticker) {
        int y = sticker.length;
        int x = sticker[0].length;

        if (y <= n && x <= m) return true;
        return false;
    }


}

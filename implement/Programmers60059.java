package com.wonseok.implement;

public class Programmers60059 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}
                , new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}})
        );
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int[][] exLock = new int[n * 3][n * 3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                exLock[n + i][n + j] = lock[i][j];
            }
        }
        for (int t = 0; t < 4; t++) {

            for (int i = 0; i < n * 2; i++) {
                for (int j = 0; j < n * 2; j++) {

                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            exLock[i + k][j + l] += key[k][l];
                        }
                    }

                    if (checkLock(exLock)) return true;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            exLock[i + k][j + l] -= key[k][l];
                        }
                    }
                }

            }
            key = rotate(key);
        }
        return false;
    }

    private static boolean checkLock(int[][] exLock) {
        int n = exLock.length;
        int length = n / 3;
        for (int i = length; i < length * 2; i++) {
            for (int j = length; j < length * 2; j++) {
                if (exLock[i][j] != 1) return false;
            }
        }
        return true;
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
        return rotate;
    }
}

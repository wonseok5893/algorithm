package com.wonseok.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj12100 {
    static StringTokenizer st;
    static int max = -1;
    static int[][] board;
    static int[][] tempBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in
        ));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        tempBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }

        // 1024 경우를 다따져봐야하나?
        for (int temp = 0; temp < 1 << (2 * 5); temp++) {
            int broke = temp;
            for (int i = 0; i < 5; i++) {
                int direction = broke % 4;
                broke /= 4;
                move(direction);
            }
            for (int[] ints : board) {
                for (int e : ints) {
                    if (e > max) max = Math.max(max, e);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = tempBoard[i][j];
                }
            }
        }
        System.out.println(max);
    }

    private static void move(int direction) {
        if (direction == 0) {
            for (int i = 0; i < board[0].length; i++) {
                int tempArr[] = new int[board.length];
                int idx = 0;
                for (int j = 0; j < board.length; j++) {
                    if (board[j][i] != 0) {
                        if (tempArr[idx] == 0)
                            tempArr[idx] = board[j][i];
                        else if (tempArr[idx] == board[j][i])
                            tempArr[idx++] *= 2;
                        else {
                            idx++;
                            tempArr[idx] = board[j][i];
                        }
                    }
                }
                for (int j = 0; j < board.length; j++) {
                    board[j][i] = tempArr[j];
                }
            }
        } else if (direction == 1) {
            for (int i = 0; i < board.length; i++) {
                int idx = board[0].length - 1;
                int tempArr[] = new int[board[0].length];
                for (int j = board[0].length - 1; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        if (tempArr[idx] == 0)
                            tempArr[idx] = board[i][j];
                        else if (tempArr[idx] == board[i][j])
                            tempArr[idx--] *= 2;
                        else {
                            idx--;
                            tempArr[idx] = board[i][j];
                        }
                    }
                }
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = tempArr[j];
                }
            }
        } else if (direction == 2) {
            for (int i = 0; i < board[0].length; i++) {
                int idx = board.length - 1;
                int tempArr[] = new int[board.length];
                for (int j = board.length - 1; j >=0; j--) {
                    if (board[j][i] != 0) {
                        if (tempArr[idx] == 0)
                            tempArr[idx] = board[j][i];
                        else if (tempArr[idx] == board[j][i])
                            tempArr[idx--] *= 2;
                        else {
                            idx--;
                            tempArr[idx] = board[j][i];
                        }
                    }
                }
                for (int j = 0; j < board.length; j++) {
                    board[j][i] = tempArr[j];
                }
            }
        } else {
            for (int i = 0; i < board.length; i++) {
                int idx = 0;
                int tempArr[] = new int[board[0].length];
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != 0) {
                        if (tempArr[idx] == 0)
                            tempArr[idx] = board[i][j];
                        else if (tempArr[idx] == board[i][j])
                            tempArr[idx++] *= 2;
                        else {
                            idx++;
                            tempArr[idx] = board[i][j];
                        }
                    }
                }
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = tempArr[j];
                }
            }

        }
    }
}

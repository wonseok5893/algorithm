package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersGameCharacter {
    public static void main(String[] args) {
        new ProgrammersGameCharacter().solution("ULURRDLLU");
    }


    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(String dirs) {
        int[][][][]visited = new int[11][11][11][11];
        int[] start = new int[]{5, 5};
        String[] splitArr = dirs.split("");
        int count = 0;
        int dir = -1;
        for (String s : splitArr) {
            switch (s) {
                case "U": {
                    dir = 0;
                    break;
                }
                case "D": {
                    dir = 1;
                    break;
                }
                case "R": {
                    dir = 2;
                    break;
                }
                case "L": {
                    dir =3;
                    break;
                }
            }
            if (!checkBoundary(start, dir)) continue;
            int nextX= start[0] + dx[dir];
            int nextY = start[1] + dy[dir];
            if (visited[start[0]][start[1]][nextX][nextY]==0&&
                    visited[nextX][nextY][start[0]][start[1]]==0) {
                count++;
                visited[start[0]][start[1]][nextX][nextY]=1;
                visited[nextX][nextY][start[0]][start[1]]=1;
            }
            start[0] = nextX;
            start[1] = nextY;
        }

        return count;

    }

    private boolean checkBoundary(int[] start, int dir) {
        int nextX = start[0] + dx[dir];
        int nextY = start[1] + dy[dir];
        if (nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10) return false;
        return true;
    }


}

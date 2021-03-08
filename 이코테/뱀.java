package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        Command[] commands = new Command[l];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            commands[i] = new Command(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int headY = 1;
        int headX = 1;
        int dir = 0;
        int time = 0;
        int commandPos = 0;
        Queue<int[]> snakes = new LinkedList<>();

        map[headY][headX] = -1;
        snakes.offer(new int[]{headX, headY});
        while (true) {
            int nextY = headY + dy[dir];
            int nextX = headX + dx[dir];
            if (nextY < 1 || nextX < 1 || nextX >= n + 1 || nextY >= n + 1||map[nextY][nextX] == -1) break;
            //사과가 있을때
            if (map[nextY][nextX] == 1) {
                headX = nextX;
                headY = nextY;
                map[headY][headX] = -1;
                snakes.offer(new int[]{headX, headY});
            } else {
                headX = nextX;
                headY = nextY;
                map[headY][headX]=-1;
                snakes.offer(new int[]{headX, headY});

                int[] info = snakes.poll();
                map[info[1]][info[0]] = 0;
            }
            time++;

            if(commandPos<l) {
                if (time == commands[commandPos].count)
                    dir = changeDir(dir, commands[commandPos++].command);
            }
        }
        System.out.println(time + 1);
    }

    private static int changeDir(int dir, String command) {
        if (command.equals("L")) {
            if (dir > 0) dir--;
            else dir = 3;
        } else {
            if (dir < 3) dir++;
            else dir = 0;
        }
        return dir;
    }

    private static class Command {
        int count;
        String command;

        public Command(int count, String command) {
            this.count = count;
            this.command = command;
        }
    }
}

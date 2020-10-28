package com.wonseok.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Boj3190 {
    static StringTokenizer st;
    static Command[] commands;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] apples = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            apples[i][0] = Integer.parseInt(st.nextToken());
            apples[i][1] = Integer.parseInt(st.nextToken());
        }
        int l = Integer.parseInt(br.readLine());
        commands = new Command[l];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            commands[i] = new Command(time, command);
        }
        //--------------------------------------------------
        Location now = new Location(0, 0, 2);

        int time = 0;
        loop:
        for (int i = 0; i < commands.length; i++) {
            Command cmd = commands[i];
            String command = cmd.command;
            for (int j = 0; j < cmd.time; j++) {
                int x = now.getX();
                int y = now.getY();
                int direct = now.getDirect();
                time++;
                int nextX = x + dx[direct];
                int nextY = y + dy[direct];
                if(nextX<0||nextY<0||nextX>=n||nextY>=n) break loop;
                now.setX(nextX);
                now.setY(nextY);
            }
                if (command.equals("D"))
                    now.setDirect(now.getDirect() + 1);
                if (command.equals("L"))
                    now.setDirect(now.getDirect() - 1);
        }
        System.out.println(time);



    }

    private static class Command {
        int time;
        String command;

        public Command(int time, String command) {
            this.time = time;
            this.command = command;
        }
    }

    private static class Location {
        int x, y, direct;

        public Location(int x, int y, int direct) {
            this.x = x;
            this.y = y;
            this.direct = direct;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getDirect() {
            return direct;
        }

        public void setDirect(int direct) {
            if (direct > 4)
                direct %= 4;
            if (direct < 0)
                direct += 4;
            this.direct = direct;
        }
    }

}

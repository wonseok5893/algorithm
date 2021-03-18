package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] trains = new int[n + 1][20];
        Queue<Command> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if (command <= 2)
                queue.offer(new Command(command, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            else
                queue.offer(new Command(command, Integer.parseInt(st.nextToken())));
        }
        while (!queue.isEmpty()) {
            Command com = queue.poll();
            com.doSomething(trains);
        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
                set.add(Arrays.toString(trains[i]));
        }
        System.out.println(set.size());
    }

    private static class Command {
        int command;
        int trainIdx;
        int seatIdx;

        public Command(int command, int trainIdx) {
            this.command = command;
            this.trainIdx = trainIdx;
        }

        public Command(int command, int trainIdx, int seatIdx) {
            this.command = command;
            this.trainIdx = trainIdx;
            this.seatIdx = seatIdx;
        }

        public void doSomething(int[][] trains) {
            switch (this.command) {
                case 1: {
                    trains[trainIdx][seatIdx - 1] = 1;
                    break;
                }
                case 2: {
                    trains[trainIdx][seatIdx - 1] = 0;
                    break;
                }
                case 3: {
                    moveBack(trains, trainIdx);
                    break;
                }
                case 4: {
                    moveFront(trains, trainIdx);
                    break;
                }
            }
        }

        private void moveFront(int[][] trains, int trainIdx) {
            for (int i = 1; i < trains[trainIdx].length; i++) {
                trains[trainIdx][i - 1] = trains[trainIdx][i];
            }
            trains[trainIdx][trains[trainIdx].length - 1] = 0;
        }

        private void moveBack(int[][] trains, int trainIdx) {
            for (int i = trains[trainIdx].length - 2; i >= 0; i--) {
                trains[trainIdx][i + 1] = trains[trainIdx][i];
            }
            trains[trainIdx][0] = 0;
        }
    }
}

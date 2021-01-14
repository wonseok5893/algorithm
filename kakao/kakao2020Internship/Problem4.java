package kakao.kakao2020Internship;

import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {
    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
    }

    public static int solution(int[][] board) {
        //방향전환을 한 다음 칸에는 + 600
        //다음칸은 +100
        Queue<Car> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        queue.offer(new Car(0, 1, 2));
        queue.offer(new Car(1, 0, 1));
        board[0][1] = 100;
        board[1][0] = 100;
        while (!queue.isEmpty()) {
            Car nowCar = queue.poll();
            int nowCarX = nowCar.x;
            int nowCarY = nowCar.y;
            int nowCarDir = nowCar.dir;

            for (int i = 0; i < 4; i++) {
                int nextX = nowCarX + dx[i];
                int nextY = nowCarY + dy[i];
                int nextDir = i;
                if (nextDir - nowCarDir == 2 || nextDir - nowCarDir == -2) continue;
                int nextCost = 0;
                if (nextX < 0 || nextY < 0 || nextX >= board[0].length || nextY >= board.length)
                    continue;
                if (board[nextY][nextX] == 1) continue;
                if (nextDir != nowCarDir) nextCost = board[nowCarY][nowCarX] + 600;
                else nextCost = board[nowCarY][nowCarX] + 100;
                if (board[nextY][nextX] == 0) {
                    board[nextY][nextX] = nextCost;
                    queue.offer(new Car(nextX, nextY, nextDir));
                }else if(board[nextY][nextX]>=nextCost){
                    board[nextY][nextX] = nextCost;
                    queue.offer(new Car(nextX, nextY, nextDir));
                }
            }
        }

        return board[board.length - 1][board[0].length - 1];
    }

    private static class Car {
        int x;
        int y;
        int dir;

        public Car(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}

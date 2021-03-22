
package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16236 {
    static StringTokenizer st;
    static int[][]visited;
    static Fish baby;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Fish> fishList = new ArrayList<>();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(0<num&&num<9){
                    fishList.add(new Fish(j, i, num));
                }
                if(num == 9){
                    baby = new Fish(j, i, 2);
                }
                map[i][j] = num;
            }
        }

        int ans = 0;
        while(true) {

            // 최단거리를 위한 bfs()
            initializeVisited(n);
            bfs(baby, map);
            ArrayList<Fish> possibleToEatFish = findPossibleToEatFish(map, baby, fishList);
            if(possibleToEatFish.size()==0)break;
            Fish toEatFish = null;
            int min = (int) 1e9;
            for (Fish eatFish : possibleToEatFish) {
                int distance = visited[eatFish.y][eatFish.x];
                if(min>distance){
                    min = distance;
                    toEatFish = eatFish;
                }else if(min==distance){
                    if(eatFish.y<toEatFish.y){
                        toEatFish = eatFish;
                    }else if(eatFish.y==toEatFish.y){
                        if(eatFish.x<toEatFish.x)
                            toEatFish = eatFish;
                    }
                }
            }

            ans += visited[toEatFish.y][toEatFish.x];
            map[toEatFish.y][toEatFish.x] = 0;
            map[baby.y][baby.x]= 0;
            fishList.remove(toEatFish);
            baby.eatFish(toEatFish);
        }
        System.out.println(ans);

    }

    private static ArrayList<Fish> findPossibleToEatFish(int[][] map,Fish baby, ArrayList<Fish> fishList) {
        ArrayList<Fish> lists = new ArrayList<>();
        for (Fish fish : fishList) {
            if(fish.size>=baby.size)continue;
            if(visited[fish.y][fish.x]==-1)continue;
            lists.add(fish);
        }
        return lists;
    }

    private static void initializeVisited(int n) {
        visited = new int[n][n];
        for (int[] arr : visited) {
            Arrays.fill(arr, -1);
        }
    }

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    private static void bfs(Fish baby, int[][] map) {
        int startX = baby.x;
        int startY = baby.y;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startY][startX] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX<0||nextY<0||nextX>= map[0].length||nextY>=map.length) continue;
                if(visited[nextY][nextX]!=-1) continue;
                if(map[nextY][nextX]>baby.size) continue;
                queue.offer(new int[]{nextX, nextY});
                visited[nextY][nextX] = visited[now[1]][now[0]]+1;
            }
        }
    }

    private static class Fish{
        int x;
        int y;
        int size;
        int eaten;

        public Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fish fish = (Fish) o;
            return x == fish.x &&
                    y == fish.y &&
                    size == fish.size &&
                    eaten == fish.eaten;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, size, eaten);
        }

        public void eatFish(Fish fish){
            this.eaten++;
            if(this.eaten==size){
                this.size++;
                this.eaten = 0;
            }
            this.y = fish.y;
            this.x = fish.x;
        }
    }
}
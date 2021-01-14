package com.wonseok.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16236 {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        Shark baby = null;
        ArrayList<Shark> sharks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                int size = Integer.parseInt(st.nextToken());
                if(size==9){
                  baby = new Shark(j,i,2);
                }else if(size!=0){
                    Shark shark = new Shark(j,i,size);
                    sharks.add(shark);
                }
            }
        }
        //check먼저 사이즈
        checkSizes(sharks,baby,n);
        System.out.println(ans);

    }

    private static void checkSizes(ArrayList<Shark> sharks, Shark baby,int n) {

        int count = 0;
        ArrayList<Shark> possibleLists = new ArrayList<>();
        int[][]map = new int[n][n];

        for (Shark shark : sharks) {
            map[shark.y][shark.x] =-1;
        }
        for (Shark shark : sharks) {
            int babySize = baby.size;
            if(shark.size<babySize) {
                count++;
                possibleLists.add(shark);
                map[shark.y][shark.x] = 0;
            }else if(shark.size==babySize) map[shark.y][shark.x] = 0;
        }
        if(count==0){
           return;
        }else{
            int[]dx = {1,0,-1,0};
            int[]dy = {0,1,0,-1};
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{baby.x,baby.y});
            map[baby.y][baby.x]=1;
            while(!queue.isEmpty()){
                int[] poll = queue.poll();
                int nowX = poll[0];
                int nowY = poll[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = nowX+dx[i];
                    int nextY = nowY+dy[i];
                    if(nextX<0||nextX<0||nextX>=n||nextY>=n)continue;
                    if(map[nextY][nextX]!=0)continue;
                    map[nextY][nextX] = map[nowY][nowX]+1;
                }
            }
            Collections.sort(possibleLists,(o1,o2)->map[o1.y][o1.x]-map[o2.y][o2.x]);
            Shark shark = possibleLists.get(0);
            ans+= map[shark.y][shark.x]-1;
            baby.addEat();
            baby.y = shark.y;
            baby.x = shark.x;
            sharks.remove(shark);
            checkSizes(sharks,baby,n);
        }
    }

    private static class Shark {
        int x;
        int y;
        int size;
        int eatCount;

        public Shark(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
        public void addEat(){
            if(eatCount>=size){
                size++;
                eatCount=0;
            }
            else eatCount++;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "x=" + x +
                    ", y=" + y +
                    ", size=" + size +
                    ", eatCount=" + eatCount +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shark shark = (Shark) o;
            return x == shark.x &&
                    y == shark.y &&
                    size == shark.size;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, size);
        }
    }
}

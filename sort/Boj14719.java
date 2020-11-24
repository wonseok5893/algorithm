package sort;

import javafx.geometry.Pos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj14719 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine()," ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int[] block = new int[width];
        for (int i = 0; i < height; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        ///
        //[3 1 2 1 3 4 0 0 1]
        int left = block[0];
        int right = block[block.length-1];
        PriorityQueue<Position> queueLeft = new PriorityQueue<>();
        PriorityQueue<Position> queueRight = new PriorityQueue<>(
                (o1,o2)-> o2.idx-o1.idx
        );
        for (int i = 1; i < block.length; i++) {
            if(left<=block[i])
            queueLeft.offer(new Position(i,block[i]));
            if(right<=block[block.length-1-i])
                queueRight.offer(new Position(block.length - 1 - i, block[block.length - 1 - i]));
        }
        int result = 0;
        int leftStartIdx = 0;
        int rightStartIdx = block.length-1;
        while(true){
            int nextLeftIdx = block.length-1;
            int nextRightIdx = 0;
            if(!queueLeft.isEmpty()){
                Position nextLeft = queueLeft.poll();
                nextLeftIdx = nextLeft.idx;
            }

            if(!queueRight.isEmpty()){
                Position nextRight = queueRight.poll();
                nextRightIdx = nextRight.idx;
            }
            if(nextLeftIdx<nextRightIdx){
                for (int i = leftStartIdx+1; i < nextLeftIdx; i++) {
                    result += left-block[i];
                }
                left = Math.max(block[nextLeftIdx],left);
                for(int i = rightStartIdx-1;i>nextRightIdx;i--){
                    result += right-block[i];
                }
                right = Math.max(block[rightStartIdx],right);
            }else break;
        }
        if(result==0){
            int max = left<right?right:left;
            for (int i = 1; i < block.length-1; i++) {
                result+= max-block[i];
            }
        }
        System.out.println(result);
    }

    private static class Position implements Comparable<Position>{
        int idx;
        int height;

        public Position(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        @Override
        public int compareTo(Position o) {
            if(idx>o.idx) return 1;
            return -1;
        }
    }
}

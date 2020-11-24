package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers42627 {
    //디스크 컨트롤러
    public static void main(String[] args) {

    }
    public int solution(int[][] jobs) {
        int pos = 0;
        int count = 0;
        int end = 0;
        int result= 0;
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        while (count < jobs.length) {
            int[]now = jobs[pos];
            end = now[1];
            PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]
            );
            for (int i = 1; pos + i < jobs.length; i++) {
                if(jobs[pos+i][0]<=end) queue.offer(jobs[pos+i]);
                else break;
            }
            if(queue.size()>0){
                while(!queue.isEmpty()){
                    int[] task = queue.poll();
                    end+=task[1];
                    result+= end-task[0];
                    count++;
                }
                pos = count+1;
            }else{
                end+=jobs[pos][1]+jobs[pos][0];
                count++;
            }
        }return 0;
    }
}

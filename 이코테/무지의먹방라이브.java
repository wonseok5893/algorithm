package 이코테;

import java.util.*;

public class 무지의먹방라이브 {
    public static void main(String[] args) {
        //회전판 음식 1~N 음식
        //먹는데 일정시간 소요
        // arr.length <= 200,000
        // 원소 값 <= 1억
        //시간을 하나씩 올리면 구할수 가 없다.
        solution(new int[]{4,2,3,6,7,1,5,8}, 27);

    }

    public static int solution(int[] food_times, long k) {
        PriorityQueue<Food> queue = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            queue.offer(new Food(i + 1, food_times[i]));
        }
        long sum  =0;
        long len = food_times.length;
        int prevLen = 0;
        while (len>0&&sum + ((queue.peek().foodTime - prevLen) * len)<=k) {
            Food food = queue.poll();
            sum += (food.foodTime-prevLen)*len;
            prevLen = food.foodTime;
            len--;
        }

        if(queue.isEmpty())return -1;

        ArrayList<Food> lists = new ArrayList<>();
        while (!queue.isEmpty()) {
            lists.add(queue.poll());
        }
        lists.sort((o1, o2) -> o1.idx - o2.idx);

       return lists.get((int) ((k - sum) % len)).idx;
        // 이부분 (k-sum)

    }

    private static class Food implements Comparable<Food>{
        int idx;
        int foodTime;

        public Food(int idx, int foodTime) {
            this.idx = idx;
            this.foodTime = foodTime;
        }

        @Override
        public int compareTo(Food o) {
            return foodTime-o.foodTime;
        }
    }
}

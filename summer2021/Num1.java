package summer2021;

import java.util.PriorityQueue;

public class Num1 {
    public static void main(String[] args) {

    }
    public int[] solution(String code, String day, String[] data) {
        // price = 가격
        // code = 6자리 수사
        // time = 날짜 YYYYMMDDHH
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        for (String d : data) {
            String[] info = d.split(" ");
            int priceT = Integer.parseInt(info[0].substring(6));
            String dayT = info[2].substring(5);
            int codeT = Integer.parseInt(info[1].substring(5));
            if(dayT.substring(0,8).equals(day)&&codeT==Integer.parseInt(code)) {
                queue.offer(new int[]{priceT, Integer.parseInt(dayT)});
            }
        }
        int size = queue.size();
        int[] ans = new int[size];
        int pos = 0;
        while (!queue.isEmpty()) {
            ans[pos++] = queue.poll()[0];
        }
        return ans;
    }
}

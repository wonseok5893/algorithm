package 이코테;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 문자열재정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        PriorityQueue<Character> queue = new PriorityQueue<>();
        int sum = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(Character.isAlphabetic(arr[i])) queue.offer(arr[i]);
            else sum += arr[i]-'0';
        }
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        sb.append(sum);
        System.out.println(sb);

    }
}

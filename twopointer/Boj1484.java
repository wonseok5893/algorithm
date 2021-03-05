package twopointer;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj1484 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> lists = new ArrayList<>();

        int start = 1;
        int end = 1;
        while (start <= end) {
            int G = end * end - start * start;
            if (G >= n) {
                if (G == n) lists.add(end);
                if (end - start <= 1) break;
                start++;
            } else end++;
        }
        StringBuffer sb = new StringBuffer();
        for (Integer e : lists) {
            sb.append(e + "\n");
        }
        if(lists.size()==0) System.out.println(-1);
        else System.out.println(sb);

    }
}

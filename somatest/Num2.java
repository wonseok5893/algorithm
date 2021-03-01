package somatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] lists = new ArrayList[p + 1];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int comNum = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());
            lists[comNum].add(hour);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= p; i++) {
            sb.append(i + " ");
            sb.append(getMax(lists[i], h) * 1000+"\n");
        }
        System.out.println(sb);
    }

    private static int getMax(ArrayList<Integer> list, int h) {
        // 1 3 7 8 9  / 5
        int[] max = new int[list.size() + 1];
        max[0] = 0;
        for (int i = 1; i <= list.size(); i++) {
            if (max[i - 1] + list.get(i - 1) <= h)
                max[i] = max[i - 1] + list.get(i - 1);
            else max[i] = max[i - 1];
        }
        return max[list.size()];
    }
}

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st;
        Map<Integer, Integer> cows = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            if(cows.get(num)==null) cows.put(num, loc);
            else{
                if(cows.get(num)!=loc) {
                    count++;
                    cows.put(num, loc);
                }
            }
        }
        System.out.println(count);

    }
}

package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17121 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] problems = new int[k];
        for (int i = 0; i < k; i++) {
            problems[i] = Integer.parseInt(br.readLine());
        }

    }
}

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int target = info[1];

        int[]coins = new int[n];
        for (int i = 0; i < n; i++) {
           coins[i] = Integer.parseInt(br.readLine());
        }

        int pos = n-1;
        int count = 0;
        while(target>0){
            if(target/coins[pos]!=0){
                count +=target/coins[pos];
                target%=coins[pos--];
                continue;
            }
            pos--;
        }
        System.out.println(count);
    }
}

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOj13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] lenArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        //
        int start = array[0];
        long sum = 0;
        long sumLen = 0;
        for (int i = 1; i < array.length; i++) {
            int next = array[i];
            sumLen += lenArr[i - 1];
            if (next > start)
                continue;
            sum += start * sumLen;
            start = next;
            sumLen = 0;
        }
        if (sumLen != 0) sum += start * sumLen;
        System.out.println(sum);

    }
}

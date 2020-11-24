package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chap12_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] splitStr = str.split("");
        Arrays.sort(splitStr);
        int idx = 0;
        int pos = 0;
        for (String s : splitStr) {
            if (s.matches("^[A-z]") == true) {
                idx = pos;
                break;
            }
            pos++;
        }
        int sum = 0;
        for (int i = 0; i < idx; i++) {
            sum += Integer.parseInt(splitStr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < splitStr.length; i++) {
            sb.append(splitStr[i]);
        }
        sb.append(sum);
        System.out.println(sb);
    }
}

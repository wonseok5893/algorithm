package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1759 {
    static StringBuilder sb = new StringBuilder();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String[] s = br.readLine().split(" ");
        visited = new int[arr[1]];
        Arrays.sort(s);
        combination(s, -1, arr[0], "");
        System.out.println(sb);
    }

    private static void combination(String[] arr, int start, int count, String res) {
        if (count == 0) {
            if (check(res))
                sb.append(res + "\n");
            return;
        }
        for (int i = start + 1; i < arr.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            res += arr[i];
            combination(arr, i, count - 1, res);
            visited[i] = 0;
            res = res.substring(0, res.length() - 1);
        }
    }

    private static boolean check(String res) {
        String[] moum = new String[]{"a","e","i","o","u"};
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if(res.indexOf(moum[i])!=-1)count++;
        }
        if(count>=1&&res.length()-count>=2)return true;
        return false;
    }
}

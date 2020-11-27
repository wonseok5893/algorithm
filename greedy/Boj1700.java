package greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1700 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();

        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int t = arr[i];
            if (set.contains(t)) continue;
            if (set.size() == n) {
                int idx = -3, target = 0;
                for (int tt : set) {
                    int tIdx = 9999;
                    for (int j = i + 1; j < m; j++) {
                        if (tt == arr[j]) {
                            tIdx = j;
                            break;
                        }
                    }
                    if (tIdx == 9999) {
                        target = tt;
                        break;
                    } else {
                        if (tIdx > idx) {
                            idx = tIdx;
                            target = arr[tIdx];
                        }
                    }
                }
                set.remove(target);
                result++;
            }
            set.add(t);
        }
        System.out.println(result);
    }

}

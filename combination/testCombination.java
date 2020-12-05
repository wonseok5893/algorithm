package combination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class testCombination {
    public static void main(String[] args) {
        new testCombination().solution(new int[]{2,1,3,4,1});
    }

    static Set<Integer> set;
    static int[] visited;

    public int[] solution(int[] numbers) {
        set = new HashSet<>();
        visited = new int[numbers.length];
        backtracking(0, numbers, 0);
        int[] result = new int[set.size()];
        int pos = 0;
        for (int e : set) {
            result[pos++] = e;
        }
        Arrays.sort(result);
        return result;
    }

    public int backtracking(int n, int[] numbers, int sum) {
        if (n == 2) {
            set.add(sum);
            return 0;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i] != 0) continue;
            visited[i] = 1;
            sum += numbers[i];
            backtracking(n + 1, numbers, sum);
            visited[i] = 0;
            sum -= numbers[i];
        }
        return 0;
    }

}

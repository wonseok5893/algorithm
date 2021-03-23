package implement;

import java.util.*;

public class Boj20164 {
    static ArrayList<Integer> set = new ArrayList<>();
    static int max = -1;
    static int min = (int) 2e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] odd = getOdd(n);

        ArrayList<Integer> lists = new ArrayList<>();
        for (int e : odd) {
            lists.add(e);
        }
        solution(n, lists);
        System.out.println(min + " " + max);
    }

    private static void solution(int n,ArrayList<Integer> lists) {

        if (n < 10) {
            if (lists.size() < min) min = lists.size();
            if (lists.size() > max) max = lists.size();
            return;
        }
        if (n < 100) {
            int num = n / 10 + n % 10;
            int[] odd = getOdd(num);
            Arrays.stream(odd).forEach((e) -> lists.add(e));
            solution(num,lists);
            Arrays.stream(odd).forEach((e) -> lists.remove(new Integer(e)));
        } else {
            String str = String.valueOf(n);
            int len = str.length();
            for (int i = 1; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int num = divide(0, i, str) + divide(i, j, str) + divide(j, len, str);
                    int[] odd = getOdd(num);
                    Arrays.stream(odd).forEach((e) -> lists.add(e));
                    solution(num,lists);
                    Arrays.stream(odd).forEach((e) -> lists.remove(new Integer(e)));
                }
            }
            //3 개로
            // 나누고
            // 0 start1 start2 end
            //합쳐
        }

    }

    private static int divide(int start, int end, String str) {
        String ans = "";
        for (int i = start; i < end; i++) {
            ans += str.charAt(i);
        }
        return Integer.parseInt(ans);
    }

    private static int[] getOdd(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt).filter(e -> e % 2 != 0)
                .toArray();
    }
}

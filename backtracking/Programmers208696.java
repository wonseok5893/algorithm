package backtracking;

public class Programmers208696 {
    //N퀸즈
    public static void main(String[] args) {
        solution(10);
    }

    static int length;

    public static int solution(int n) {
        int[][] map = new int[n][n];
        length = n;
        backtracking(map, 0);
        return 1;
    }

    private static void backtracking(int[][] map, int step) {
        if (step == length) {
            for (int[] ints : map) {
                for (int e : ints) {
                    System.out.print(e+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < length; i++) {
            map[step][i] = 1;
            backtracking(map, step + 1);
            map[step][i] = 0;
        }
    }

    private static boolean check(int[][] map) {
        return true;
    }

}

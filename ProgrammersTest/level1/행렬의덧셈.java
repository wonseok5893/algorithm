package ProgrammersTest.level1;

public class 행렬의덧셈 {
    public static void main(String[] args) {

    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] ans = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                ans[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return ans;
    }
}

package kakao.level2;

public class 행렬의곱셈 {
    public static void main(String[] args) {
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1 4          // 3 3
        // 3 2          // 3 3
        // 4 1
        //3 x 2  2 x 2
        int[][]ans = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum +=arr1[i][k]*arr2[k][j];
                }
                ans[i][j] = sum;
            }
        }
        return ans;

    }
}

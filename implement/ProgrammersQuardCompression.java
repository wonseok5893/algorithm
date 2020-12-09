package implement;

public class ProgrammersQuardCompression {
    public static void main(String[] args) {
        new ProgrammersQuardCompression().solution(new int[][]
                {{1, 1, 1, 1}, {1, 1, 0, 0}, {1, 1, 1, 1}, {0, 0, 1, 1}});
    }
    // 1 1 1 1
    // 1 1 0 0
    // 1 1 1 1
    // 0 0 1 1


    static int count0;
    static int count1;

    public int[] solution(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) count0++;
                else count1++;
            }
        }
        int n = arr.length;
        if (!check(arr, 0, 0, n))
            divideArr(arr, 0, 0, n);
        System.out.println(count0+" "+ count1);
        return new int[]{count0, count1};
    }

    private void divideArr(int[][] arr, int startX, int startY, int n) {
        if (n <= 2) {
            return;
        }
        if (!check(arr, startX, startY, n / 2)) divideArr(arr, startX, startY, n / 2);
        if (!check(arr, startX + n / 2, startY, n / 2)) divideArr(arr, startX + n / 2, startY, n / 2);
        if (!check(arr, startX, startY + n / 2, n / 2)) divideArr(arr, startX, startY+n/2, n / 2);
        if (!check(arr, startX + n / 2, startY + n / 2, n / 2)) divideArr(arr, startX + n / 2, startY + n / 2, n / 2);
    }

    private boolean check(int[][] arr, int startX, int startY, int n) {
        int temp = arr[startY][startX];
        boolean result = true;
        for (int j = startY; j < startY + n; j++) {
            for (int i = startX; i < startX + n; i++) {
                if (arr[j][i] != temp) {
                    result = false;
                    return result;
                }
            }
        }
        if (result) {
            if (temp == 1) count1 -= n * n - 1;
            else count0 -= n * n - 1;
        }
        return true;
    }
}

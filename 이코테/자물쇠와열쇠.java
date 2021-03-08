package 이코테;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = new int[][]{
                {0, 0, 0}, {1, 0, 0}, {0, 1, 1}
        };
        int[][] lock = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        new 자물쇠와열쇠().solution(key, lock);
    }

    public boolean solution(int[][] key, int[][] lock) {
        int K = key.length;
        int L = lock.length;

        int[][] extendKey = new int[L + 2 * K][L + 2 * K];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                extendKey[i + K][j + K] = lock[i][j];
            }
        }
        int count = 0;
        for (int i = 1; i < L + K; i++) {
            for (int j = 1; j < L + K; j++) {
                for (int k = 0; k < 4; k++) {
                    int[][] temp = cloneArr(extendKey);
                    key = rotate(key);
                    print(temp, i, j, key);
                    //칠함
                    if (check(temp, L, K)) return true;
                }
            }
        }
        return false;
    }

    private int[][] cloneArr(int[][] extendKey) {
        int[][] temp = new int[extendKey.length][extendKey[0].length];
        for (int i = 0; i < extendKey.length; i++) {
            for (int j = 0; j < extendKey[0].length; j++) {
                temp[i][j] = extendKey[i][j];
            }
        }
        return temp;
    }

    private int[][] rotate(int[][] temp) {
        int[][] arr = new int[temp.length][temp[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                arr[j][i] = temp[temp.length - 1 - i][j];
            }
        }

        return arr;
    }

    private void print(int[][] extendKey, int i, int j, int[][] key) {
        for (int k = 0; k < key.length; k++) {
            for (int l = 0; l < key.length; l++) {
                extendKey[i + k][j + l] += key[k][l];
            }
        }
    }

    private boolean check(int[][] extendKey, int l, int k) {
        for (int i = l; i < l + k; i++) {
            for (int j = l; j < l + k; j++) {
                if (extendKey[i][j] != 1) return false;
            }
        }
        return true;
    }
}

package ProgrammersTest.level1;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {

    }
    public int[] solution(int[] array, int[][] commands) {
        int[] res = new int[commands.length];
        int resPos = 0;
        for (int[]command : commands) {
            int start = command[0];
            int end = command[1];
            int pos = command[2];

            int[]temp = new int[end-start+1];
            int tempPos = 0;
            for (int i = start; i <end+1 ; i++) {
                temp[tempPos++] = array[i-1];
            }
            Arrays.sort(temp);
            res[resPos++] = temp[pos-1];
        }
        return res;
    }

}

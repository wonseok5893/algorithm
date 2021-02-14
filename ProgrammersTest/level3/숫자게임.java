package ProgrammersTest.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 숫자게임 {
    public static void main(String[] args) {
        //[5,1,3,7]        1 3 5 7
        //[2,2,6,8]        2 2 6 8
        new 숫자게임().solution(new int[]{1,3,5,7},new int[]{2,2,6,8});
    }

    public int solution(int[] A, int[] B) {
        // 이길거면 가장 작은 점수로 이기는게 이득
        Arrays.sort(A);
        Arrays.sort(B);

        int count = 0;
        int aPos=0;
        int bPos = 0;
        int len = A.length;
        while(aPos<len&&bPos<len)
        {
            if(A[aPos]>=B[bPos]){
                bPos++;
            }else{
                aPos++;
                bPos++;
                count++;
            }
        }
        return count;

    }


}

package kakao2021internship;

import java.util.Arrays;
import java.util.Stack;

public class Num3 {
    public static void main(String[] args) {
        new Num3().solution(8, 2
                , new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
    }

    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> delStack = new Stack<>();
        int[] arr = new int[n];
        int[] next = new int[n];
        int[] before = new int[n];
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        before[0] = -1;
        for (int i = 1; i < n; i++) {
            before[i] = i - 1;
        }
        boolean[] exist = new boolean[n];
        Arrays.fill(exist, true);

        int pointer = k;

        for (String oper : cmd) {
            if (oper.equals("C")) {
                // 현재 선택된 항 삭제 바로 아래항 선택
                // 마지막 삭제된행인 경우 바로 윗행 선택
                exist[pointer] = false;
                int del = delStack.push(pointer);
                if (next[pointer] == -1)
                    pointer = before[pointer];
                else pointer = next[pointer];

                int bef = before[del];
                int aft = next[del];
                if (bef != -1)
                    next[bef] = aft;
                if (aft != -1)
                    before[aft] = bef;

            } else if (oper.equals("Z")) {
                int recover = delStack.pop();
                exist[recover] = true;

                int temp = recover - 1;
                int bef = -1;
                int aft = -1;
                while (temp >= 0) {
                    if (exist[temp]) {
                        bef = temp;
                        break;
                    }
                    temp--;
                }
                temp = recover + 1;
                while (temp < n) {
                    if (exist[temp]) {
                        aft = temp;
                        break;
                    }
                    temp++;
                }

                if (bef != -1)
                    next[bef] = recover;
                if (aft != -1)
                    before[aft] = recover;

                before[recover] = bef;
                next[recover] = aft;

                // 최근 삭제된 행을 원래대로 복구
                // 현재 선택된 행은 바뀌지 않는다.
            } else {
                String[] operArr = oper.split(" ");
                int cnt = Integer.parseInt(operArr[1]);
                if (operArr[0].equals("U")) {
                    while (cnt-- > 0) {
                        if (before[pointer] != -1)
                            pointer = before[pointer];
                    }
                } else {
                    while (cnt-- > 0) {
                        if (next[pointer] != -1)
                            pointer = next[pointer];
                    }
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(exist[i])sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }

}

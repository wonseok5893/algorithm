package dev;

public class Num1 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] cnt = new int[46];
        for (int lotto : lottos) {
            cnt[lotto]++;
        }
        int ans = 0;
        for (int win_num : win_nums) {
            if (cnt[win_num] > 0) ans++;
        }
        int max = ans + cnt[0];
        return new int[]{getPriority(max),getPriority(ans)};
    }

    private int getPriority(int count) {
        switch (count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}

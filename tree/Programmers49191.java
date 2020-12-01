package tree;

import java.util.*;

public class Programmers49191 {
    public static void main(String[] args) {
        //[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]
        solution(8, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}});
    }

    public static int solution(int n, int[][] results) {
        ArrayList<Athlete> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new Athlete(i));
        }

        for (int[] info : results) {
            list.get(info[0]).winAdd(info[1]);
            list.get(info[1]).loseAdd(info[0]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                Athlete athlete = list.get(j);
                HashSet<Integer> addWin = new HashSet<>();
                HashSet<Integer> addLose = new HashSet<>();
                for (int e : athlete.winList) {
                    for (int w : list.get(e).winList) {
                        addWin.add(w);
                    }
                }
                athlete.winList.addAll(addWin);

                for (int e : athlete.loseList) {
                    for (int w : list.get(e).loseList) {
                        addLose.add(w);
                    }
                }
                athlete.loseList.addAll(addLose);
            }
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            int winCount = list.get(i).winList.size();
            int loseCount = list.get(i).loseList.size();
            if (winCount + loseCount == n - 1) answer++;
        }

        return answer;
    }

    private static class Athlete {
        int num;
        Set<Integer> winList;
        Set<Integer> loseList;

        public Athlete(int num) {
            this.num = num;
            this.loseList = new HashSet<>();
            this.winList = new HashSet<>();
        }

        public void winAdd(int e) {
            winList.add(e);
        }

        public void loseAdd(int e) {
            loseList.add(e);
        }

    }
}

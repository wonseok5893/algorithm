package com.wonseok.ProgrammersTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Num2 {
    public static void main(String[] args) {
        new Num2().solution(new String[]{"jack:9,10,13,9,15", "jerry:7,7,14,10,17", "jean:0,0,11,20,0", "alex:21,2,7,11,4", "kevin:8,4,5,0,0", "brown:3,5,16,3,18", "ted:0,8,0,0,8", "lala:0,12,0,7,9", "hue:17,16,8,6,10", "elsa:11,13,10,4,13"});
    }

    public String[] solution(String[] record) {
        //"jack:9,10,13,9,15"
        ArrayList<Athlete> list = new ArrayList<>();
        for (String str : record) {
            String[] info = str.split(":");
            String name = info[0];
            int[] scoreArr = Arrays.stream(info[1].split(","))
                    .mapToInt(Integer::parseInt).toArray();
            list.add(new Athlete(name, scoreArr));
        }

        for (int j = 0; j < 5; j++) {
            int idx = j;
            Collections.sort(list, new Comparator<Athlete>() {
                @Override
                public int compare(Athlete o1, Athlete o2) {
                    return o1.score[idx] - o2.score[idx];
                }
            });
            int n = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).score[idx] != 0) n++;
            }
            int goldCut = olim(n, 12);
            int silverCut = olim(n, 4);
            int bronzeCut = olim(n, 2);

            int start = 0;
            for (int i = 0; i < list.size(); i++) {
                Athlete now = list.get(i);
                if (now.score[idx] != 0) {
                    if (start < goldCut)
                        now.gold++;
                    else if (start < silverCut)
                        now.silver++;
                    else if (start < bronzeCut)
                        now.bronze++;
                    start++;
                }
            }
        }
        Collections.sort(list, new Comparator<Athlete>() {
            @Override
            public int compare(Athlete o1, Athlete o2) {
                int countA = 0;
                int countB = 0;
                int hardA = 0;
                int hardB = 0;
                int totalA = 0;
                int totalB = 0;
                for (int i = 0; i < 5; i++) {
                    if (o1.score[i] != 0) {
                        countA++;
                        totalA += o1.score[i];
                        hardA = i;
                    }
                    if (o2.score[i] != 0) {
                        countB++;
                        totalB += o2.score[i];
                        hardB = i;
                    }
                }
                if (countA < countB) return 1;
                else if (countA == countB) {
                    if (hardA < hardB) return 1;
                    else if (hardA == hardB) {
                        if (o1.gold < o2.gold)
                            return 1;
                        else if (o1.gold == o2.gold) {
                            if (o1.silver < o2.silver)
                                return 1;
                            else if (o1.silver == o2.silver) {
                                if (o1.bronze < o2.bronze)
                                    return 1;
                                else if (o1.bronze == o2.bronze) {
                                    if (totalA > totalB) return 1;
                                    else if (totalA == totalB) {
                                        return o1.name.compareTo(o2.name);
                                    }
                                    return -1;
                                }
                                return -1;
                            }
                            return -1;

                        }
                        return -1;
                    }
                    return -1;
                }
                return -1;
            }
        });
       String[]result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).name;
        }
        return result;
    }

    private int olim(int e, int n) {
        if (e % n == 0) return e / n;
        else return e / n + 1;
    }

    private class Athlete {
        String name;
        int[] score;
        int gold;
        int silver;
        int bronze;

        public Athlete(String name, int[] score) {
            this.name = name;
            this.score = score;
        }
    }
}

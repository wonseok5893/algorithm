package twopointer;

import java.util.StringTokenizer;

public class Programmers광고삽입 {
    public static void main(String[] args) {
        new Programmers광고삽입().solution("", "", null);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int totalLen = parseTime(play_time);
        int advLen = parseTime(adv_time);

        int[] time = new int[totalLen + 1];
        for (String log : logs) {
            String[] arr = log.split("-");
            int start = parseTime(arr[0]);
            int end = parseTime(arr[1]);

            for (int i = start; i < end; i++) {
                time[i]++;
            }
        }

        // 구간합 최대
        int start = 0;
        int end = 0;
        long sum = 0;
        long max = -1;
        int ans = 0;
        while (start <= end) {
            if (end - start >= advLen) {
                if (end - start == advLen) {
                    if (max < sum) {
                        max = sum;
                        ans = start;
                    }
                }
                sum -= time[start++];
            } else if (end == totalLen + 1) break;
            else sum += time[end++];
        }


        return toTime(ans);
    }

    private String toTime(int time) {
        int[] arr = new int[3];
        int mod = 3600;
        int pos = 0;
        while (pos < 2) {
            arr[pos++] = time / mod;
            time %= mod;
            mod /= 60;
        }
        arr[pos] = time;
        String ans = "";
        for (int e : arr) {
            if (e < 10) ans += "0" + e;
            else ans += e;
            ans += ":";
        }

        return ans.substring(0, ans.length() - 1);
    }

    private int parseTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int ans = 0;
        int mul = 3600;
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            ans += a * mul;
            mul /= 60;
        }
        return ans;
    }
}

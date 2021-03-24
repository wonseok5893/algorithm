package baekjoontest.제2회류호석배알고리즘코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<int[]> wonseoks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //고른거에서 다음거를 고를때 전에 좌표를 가지고
            wonseoks.add(new int[]{x, y, v});
        }
        Collections.sort(wonseoks, (o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] == o2[1]) {
                if (o1[0] > o2[0]) return 1;
            }
            return -1;
        });
        for (int[] wonseok : wonseoks) {
            System.out.println(Arrays.toString(wonseok));
        }
        // 높이를 기준으로 먼저 다음 x좌표 기준
        //[2, 4, 1],[4, 5, 5],[5, 7, 6],[3, 8, 10],[1, 10, 10]
        //중간 값
        int count = 0;
        int middle = 0;
        int maxY =-1;
        int maxX = -1;
        int beforeX = -1;
        int beforeY = -1;
        while (count < c) {
            int[] wonseok = wonseoks.get(count);
            middle += wonseok[2];
            maxX = wonseok[0];
            maxY = wonseok[1];
        }
        while(maxY)


    }
}

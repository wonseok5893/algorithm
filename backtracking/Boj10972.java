package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10972 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //배열이 내림차순이면 -1
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp, (a, b) -> b - a);
        boolean res = false;
        for (int i = 0; i < n; i++) {
            if (temp[i] != arr[i]) {
                res =true;
                break;
            }
        }

        if(!res) System.out.println(-1);
        else{
            // 0~ n-1
            // n-2 부터 ~ 0까지 살펴보고
            // 자기 인덱스 보다 두에있는 인덱스에 큰게있으면 그중 제일 작은거랑 바꾸고 뒤에꺼 정렬
            int idx = -1;
            int chageIdx = -1;
            int min = (int)2e9;
            for (int i = n-2; i >=0 ; i--) {
                for (int j = n-1; j >i ; j--) {
                    if (arr[j] > arr[i]) {
                        if(min>arr[j]) {
                            min = arr[j];
                            idx = i;
                            chageIdx = j;
                        }
                    }
                }
                if(idx!=-1)break;
            }
            int tempV = arr[idx];
            arr[idx] = arr[chageIdx];
            arr[chageIdx] = tempV;
            Arrays.sort(arr, idx + 1, arr.length);

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
        }


        //1 3 4 2
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

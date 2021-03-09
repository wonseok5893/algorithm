package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Person> queue = new PriorityQueue<Person>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            queue.offer(new Person(name, kor, eng, math));
        }
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            Person poll = queue.poll();
            sb.append(poll.name + "\n");
        }
        System.out.println(sb);
    }

    private static class Person implements Comparable<Person> {

        String name;
        int kor;
        int eng;
        int math;

        public Person(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Person o) {
            if(kor<o.kor) return 1;
            else if(kor == o.kor){
                if(eng>o.eng) return 1;
                else if(eng==o.eng){
                    if(math<o.math)return 1;
                    else if(math==o.math){
                        return name.compareTo(o.name);
                    }
                }
            }
            return -1;
        }
    }
}

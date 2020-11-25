package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Student> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Student student = new Student(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            queue.offer(student);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Student poll = queue.poll();
            sb.append(poll.name+"\n");
        }
        System.out.println(sb);
    }

    private static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(kor<o.kor)return 1;
            else if(kor==o.kor){
                if(eng>o.eng)return 1;
                else if(eng==o.eng){
                    if(math<o.math)return 1;
                    else if(math==o.math)return name.compareTo(o.name);
                }
            }
            return -1;
        }
    }
}

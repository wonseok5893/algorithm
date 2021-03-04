package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Boj2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // -n ~ n
        int start = 0;
    }

    static class Balloon {
        int value;
        int num;
        Balloon next;
        Balloon back;
    }

    static class CircularLinkedList {
        int loc;
        Balloon root;
        int size;

        public CircularLinkedList(Balloon root) {
            loc = root.num;
            this.root = root;
            size = 1;
        }

    }
}

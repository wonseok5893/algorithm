
package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj1991 {
    static StringBuffer sb = new StringBuffer();
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new char[26][3];

        for (int i = 0; i < nodeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            char node = st.nextToken().charAt(0);
            graph[node - 65][0] = node;
            graph[node - 65][1] = st.nextToken().charAt(0);
            graph[node - 65][2] = st.nextToken().charAt(0);

        }
        int start = 0;
        preOrder(start);
        sb.append("\n");
        midOrder(start);
        sb.append("\n");
        postOrder(start);
        System.out.println(sb);
    }

    private static void postOrder(int start) {
        if (graph[start][1] != '.') postOrder(graph[start][1] - 65);
        if (graph[start][2] != '.') postOrder(graph[start][2] - 65);
        sb.append((char)(start+65));
    }

    private static void midOrder(int start) {
        if (graph[start][1] != '.') midOrder(graph[start][1] - 65);
        sb.append((char)(start+65));
        if (graph[start][2] != '.') midOrder(graph[start][2] - 65);
    }

    private static void preOrder(int start) {
        sb.append((char)(start+65));
        if (graph[start][1] != '.') preOrder(graph[start][1] - 65);
        if (graph[start][2] != '.') preOrder(graph[start][2] - 65);
    }

}

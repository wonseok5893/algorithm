package somatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1 {
    //근접 공격 → 염력 이후 회복이나 물 뿌리기와 같이 스킬 사용 이후
    // 연계되는 스킬이 있다면 중간에 스킬을 중단할 수 없다.
    //염력 스킬과 같은 연계 스킬의 경우 단독으로 사용할 수 없다.
    //단독 스킬 하나로만 구성된 경우는 스킬 구성에서 제외한다.
    //하나의 스킬은 여러 개의 후행 스킬을 가질 수 있지만 (1:NN) 여러 개의 선행 스킬을 가질 수는 없다. (1:1)
    //스킬이 무한으로 연계되는 상황은 없다고 가정한다.
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<String> skills = new ArrayList<>();

        while (st.hasMoreTokens()) {
            skills.add(st.nextToken());
        }
        //연계스킬 개수
        int n = Integer.parseInt(br.readLine());

        Map<String, ArrayList<String>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String start = st.nextToken();
            String next = st.nextToken();

            skills.remove(next);

            if (graph.get(start) == null) {
                graph.put(start, new ArrayList<>());
                graph.get(start).add(next);
            } else graph.get(start).add(next);
        }

        for (String firstSkill : skills) {
            ArrayList<String> list = new ArrayList<>();
            ;
            list.add(firstSkill);
            get_skill_tree(firstSkill, list, graph);
        }
        System.out.println(sb);
    }

    private static void get_skill_tree(String firstSkill, ArrayList<String> list, Map<String, ArrayList<String>> graph) {
        if ( graph.get(firstSkill) == null||graph.get(firstSkill).size() == 0) {
            if (list.size() > 1) {
                for (String s : list) {
                    sb.append(s+" ");
                }
                sb.append("\n");
            }
            return;
        }

        for (String s : graph.get(firstSkill)) {
            list.add(s);
            get_skill_tree(s, list, graph);
            list.remove(s);
        }
    }
}

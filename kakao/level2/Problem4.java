package kakao.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Problem4 {
    public static void main(String[] args) {
        new Problem4().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

    public int[] solution(String s) {
        ArrayList<Integer>[] list = new ArrayList[501];
        for (int i = 0; i <= 500; i++) {
            list[i] = new ArrayList<>();
        }
        Stack<String> stack = new Stack<>();
        String[] split = s.split("");
        String result = "";
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (str.equals("{")) continue;
            else if (str.equals("}")) {
                stack.push(result);
                result = "";
            } else
                result += str;
        }
        int pos = 0;
        while (!stack.isEmpty()) {
            if (!stack.equals("")) {
                String[] splitArr = stack.pop().split(",");
                for (String str : splitArr) {
                    if (!str.equals("")) {
                        list[pos].add(Integer.parseInt(str));
                    }
                }
                pos++;
            }
        }
        ArrayList<Integer> resultArr = new ArrayList<>();
        Arrays.sort(list,(o1, o2)->o1.size()-o2.size());
        for (ArrayList<Integer> array : list) {
            if(array.size()==0) continue;
            for (Integer e : array) {
            if(!resultArr.contains(e))
                resultArr.add(e);
            }
        }
        int[] ans = new int[resultArr.size()];
        for (int i = 0; i < resultArr.size(); i++) {
            ans[i] = resultArr.get(i);
        }
        return ans;
    }
}

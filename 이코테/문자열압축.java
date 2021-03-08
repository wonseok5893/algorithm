package 이코테;

public class 문자열압축 {
    public static void main(String[] args) {
        new 문자열압축().solution("a");
    }

    public int solution(String s) {
        int maxLen = s.length() / 2;
        int min = 1001;
        for (int i = 1; i <= maxLen; i++) {
            min = Math.min(min,getCompStr(s, i));
        }
        return min!=1001?min:1;
    }

    private int getCompStr(String s, int len) {
        int pos = 0;
        String res = "";
        int count = 1;
        String now = s.substring(pos, pos + len);
        while (pos+len<=s.length()) {
            String next = s.substring(pos + len, Math.min(s.length(), pos + 2 * len));
            if (now.equals(next)) {
                count++;
            } else {
                if (count != 1) {
                    res += count + now;
                } else res += now;
                count = 1;
                now = next;
            }
            pos += len;
        }
        res += now;
        System.out.println(res);
        return res.length();
    }
}

package implement;

public class Programmers208959 {
    public static void main(String[] args) {
        //리틀 프렌즈 사천성
        solution(3,3,new String[]{"DBA","C*A","CDB"});
    }
    public static String solution(int m, int n, String[] board) {
        char[][]map = new char[n][m];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        //바깥쪽부터 차례대로 보자;
        for (char[] chars : map) {
            for (char e : chars) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
        return "";
    }
}

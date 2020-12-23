package kakao.level1;

import java.util.Stack;

public class Problem1 {
    public static void main(String[] args) {
        new Problem1().solution()
    }
    static int ans;
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<moves.length;i++){
            int removeIdx =  moves[i]-1;
            for(int j=0;j<board.length;j++){
                if(board[j][removeIdx]!=0){
                    stack.push(board[j][removeIdx]);
                    check(stack);
                    board[j][removeIdx]=0;
                    break;
                }
            }
        }
        return ans;
    }
    public void check(Stack<Integer> stack){
        if (stack.size()>=2){
            int firstPeek = stack.pop();
            int secondPeek = stack.peek();
            if(firstPeek==secondPeek){
                ans+=2;
                stack.pop();
            }else {
                stack.push(firstPeek);
            }
        }
    }
}

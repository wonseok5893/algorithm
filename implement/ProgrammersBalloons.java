package implement;

public class ProgrammersBalloons {
    public static void main(String[] args) {
        System.out.println();
    }
    public int solution(int[] a) {
        int answer = 2;
        int left = a[0];
        int right = a[a.length-1];
        for (int i = 1; i <a.length-1; i++) {
            if(a[i]<left) {
                answer++;
                left = a[i];
            }
            if(a[a.length-1-i]<right){
                answer++;
                right = a[a.length-1-i];
            }
            if(left==right)break;
        }
        if(left==right) answer--;
        return answer;
     }

}

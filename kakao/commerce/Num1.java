package kakao.commerce;

public class Num1 {
    public static void main(String[] args) {
        int solution = new Num1().solution(new int[]{1, 4, 4, 4, 4, 5}
                , new int[]{2, 3, 4, 3, 2, 3});
        System.out.println(solution);
    }
    public int solution(int[] gift_cards, int[] wants) {
        int answer = gift_cards.length;
        //100,000
        int[] cnt = new int[100001];
        for (int gift : gift_cards) {
            cnt[gift]++;
        }
        for (int want : wants) {
            if(cnt[want]-->0)answer--;
        }

        return answer;
    }
    //[4, 5, 3, 2, 1]	[2, 4, 4, 5, 1]
    // 1 1 1        0 2 1
}

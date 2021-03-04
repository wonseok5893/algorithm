package 이코테;

public class 볼링공고르기 {
    public static void main(String[] args) {
        // A와 B가 볼링을 치고있다.
        // 두사람은 서로 다른 무게를 골라야한다.
        // 공은 N개가 있고
        // 공의 번호는 1번 부터 순서대로 부여된다.
        // 볼링공의 무게는 1~ M
        // 두사람이 고를 수 있는 볼링공 번호의 조합의 수

        int n = 5;
        int m = 3;
        int[] arr = new int[]{1,5,4,3,2,4,5,2};

        solution(arr);
    }

    private static void solution(int[] arr) {
        int ans = 0;
        int aPos = 0;
        // A가 고른 idx 이후에  B가 선태갛면 된다
        while(aPos< arr.length){
            int bPos = aPos+1;
            while(bPos< arr.length){
                if(arr[aPos]!= arr[bPos]){
                    ans++;
                    System.out.println("( "+(aPos+1)+", "+(bPos+1)+" )");
                }
                bPos++;
            }
            aPos++;
        }
        System.out.println(ans);
    }
}

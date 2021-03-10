package 이코테;

public class 탑승구 {
    public static void main(String[] args) {
        // 탑승구 G개 1~G번
        // P개의 비행기
        int g = 4;
        int p = 3;
        solution(g, p, new int[]{4, 1, 1});
    }

    private static void solution(int g, int p, int[] arr) {
        int[] entrances = new int[g + 1];
        for (int i = 0; i <= g; i++) {
            entrances[i] = i;
        }
        int res = 0;
        for (int num : arr) {
            int parent = findParent(entrances, num);
            if (parent == 0) {
                break;
            }
            union(entrances, num, num - 1);

            res++;
        }
        System.out.println(res);
    }

    private static void union(int[] entrances, int num, int left) {
        int a = findParent(entrances, num);
        int b = findParent(entrances, left);
        entrances[a] = findParent(entrances, b);
    }

    private static int findParent(int[] entrances, int num) {
        if (entrances[num] == num) return num;
        return entrances[num] = findParent(entrances, entrances[num]);
    }

}

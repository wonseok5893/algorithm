package com.wonseok.backtracking;

public class ProgrammersBacktracking {
    public static void main(String[] args) {
        new ProgrammersBacktracking().solution(new int[]{1,2,3,4});
    }
    static int ans;
    static int[] arr;

    public int solution(int[] nums) {
        arr = new int[3001];
        arr[0] = -1;
        arr[1] = -1;
        for(int i=2;i<= 3000;i++){
            if(arr[i] == -1) continue;
            for(int j = 2*i;j<=3000;j+=i) arr[j] = -1;
        }

       int[] visited = new int[nums.length];
        backtracking(nums,0, visited,0);
        return ans/6;
    }
    public void backtracking(int[]nums,int count,int[]visited,int sum){
        if(count==3){
            if(arr[sum]!=-1)
                ans++;
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==1)continue;
            visited[i] = 1;
            sum+= nums[i];
            backtracking(nums,count+1,visited,sum);
            sum -= nums[i];
            visited[i] = 0;
        }

    }
}

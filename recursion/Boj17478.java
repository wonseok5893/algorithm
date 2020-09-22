package com.wonseok.recursion;

import java.util.Scanner;

public class Boj17478 {
    static int n;
    static StringBuilder sb;
    static StringBuilder append;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sb = new StringBuilder();
        append = new StringBuilder();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(n+1);
        System.out.println(sb);
    }

    private static void recursion(int k) {
        if(k==0){
            return;
        }
        sb.append(append+"\"재귀함수가 뭔가요?\"\n");
        if(k!=1) {
            sb.append(append + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(append + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(append + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        }else{
            sb.append(append + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }
        append = append.append("____");
        recursion(k-1);
        append.delete(append.length() - 4, append.length());
        sb.append(append+"라고 답변하였지.\n");
    }
}

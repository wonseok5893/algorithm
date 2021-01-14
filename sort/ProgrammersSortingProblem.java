package com.wonseok.sort;

import com.wonseok.kakao.level2.Problem3;

import java.util.PriorityQueue;

public class ProgrammersSortingProblem {
    public static void main(String[] args) {

        String[] solution = new ProgrammersSortingProblem().solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" });
        for (String s : solution) {
            System.out.println(s);
        }
    }
    public String[] solution(String[] files) {
        PriorityQueue<File> queue = new PriorityQueue<File>();
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            queue.offer(new File(file,i));
        }
        String[]ans = new String[files.length];
        int pos = 0;
        while(!queue.isEmpty()){
            File file= queue.poll();

            ans[pos++] = files[file.idx];
        }
        return ans;
    }
    static class File implements Comparable<File>{
        int idx;
        String head;
        String num;
        String tail;
        File(String str,int idx){
            str = str.toUpperCase();
            int startPos = -1;
            int endPos = -1;
            for(int i=0;i<str.length();i++){
                if(Character.isDigit(str.charAt(i))){
                    if(startPos==-1) startPos = i;
                    endPos = i;
                }else{
                    if(endPos!=-1)break;
                }

            }   this.idx = idx;
                this.head = str.substring(0,startPos);
                this.num = str.substring(startPos,endPos+1);
                this.tail = str.substring(endPos+1);
        }
        @Override
        public int compareTo(File o) {
            if(!head.equals(o.head)) return head.compareTo(o.head);
            else{
                if(Integer.parseInt(num) - Integer.parseInt(o.num)>0) return 1;
                else if(Integer.parseInt(num) - Integer.parseInt(o.num)==0){
                    if(idx-o.idx>0)return 1;
                }
            }
            return -1;
        }
    }
}

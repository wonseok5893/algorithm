package com.wonseok.kakao.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Problem1 {
    public static void main(String[] args) {

    }

    static ArrayList<Frame> list = new ArrayList<>();
    public int[][] solution(int n, int[][] build_frame) {

        for (int[] frame : build_frame) {
            int x = frame[0], y= frame[1], thing=frame[2], oper = frame[3];
            Frame info = new Frame(x, y, thing);
            if(oper==1){
                list.add(info);
                if(!check())list.remove(info);
            }else{
                list.remove(info);
                if(!check())list.add(info);
            }
        }
        Collections.sort(list);
        int[][] ans = new int[list.size()][3];
        int pos = 0;
        for(Frame frame :list){
            System.out.print(frame.x+" "+frame.y+" "+frame.thing);
            System.out.println();
            ans[pos][0] = frame.x;
            ans[pos][1] = frame.y;
            ans[pos++][2] = frame.thing;
        }
        return ans;
    }

    private boolean check() {
        for(Frame frame:list){
           if(frame.thing==0) {
               if (frame.y == 0 || list.contains(new Frame(frame.x - 1, frame.y, 1))
                       || list.contains(new Frame(frame.x, frame.y, 1))
                       || list.contains(new Frame(frame.x, frame.y - 1, 0))) continue;
               else return false;
           }else{
                    if (list.contains(new Frame(frame.x,frame.y-1,0))
                            || list.contains(new Frame(frame.x+1,frame.y-1,0))
                            || (list.contains(new Frame(frame.x-1,frame.y,1)) && list.contains(new Frame(frame.x+1,frame.y,1)))) continue;
                    else return false;
            }
        }
        return true;
    }

    private static class Frame implements Comparable<Frame> {
        int x;
        int y;
        int thing;

        public Frame(int x, int y, int thing) {
            this.x = x;
            this.y = y;
            this.thing = thing;
        }

        @Override
        public int compareTo(Frame o) {
            if (x < o.x) return -1;
            else if (x == o.x) {

                if (y < o.y) return -1;
                else if (y == o.y) {
                    if (thing < o.thing) return -1;
                    else return 1;
                }
            }
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Frame frame = (Frame) o;
            return x == frame.x &&
                    y == frame.y &&
                    thing == frame.thing;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, thing);
        }
    }
}

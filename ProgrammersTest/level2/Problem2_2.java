package com.wonseok.ProgrammersTest.level2;

import java.util.ArrayList;
import java.util.Collections;

public class Problem2_2 {
    public static void main(String[] args) {
        System.out.println(new Problem2_2().solution("CC#BCC#BCC#BCC#B",new String[]{"03:00,03:30,FOO,CC#B","04:00,04:08,BAR,CC#BCC#BCC#B"}));
    }
    public String solution(String m, String[] musicinfos) {
       m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("E#","e");
        m =  m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        m = m.replaceAll("A#","a");
        ArrayList<Music> lists = new ArrayList<>();
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            lists.add(new Music(split[0],split[1],split[2],split[3]));
        }
        ArrayList<Music> ans = new ArrayList<>();
        for (Music list : lists) {
            if(list.checkMusic(m))ans.add(list);
        }
        Collections.sort(ans);
        if(ans.size()==0) return "(None)";
        return ans.get(0).str;
    }
    class Music implements Comparable<Music>{
        int startTime;
        int endTime;
        String str;
        String oct;
        Music(String startTime,String endTime,String str,String oct){
            String[] startSplit = startTime.split(":");
            String[] endSplit = endTime.split(":");
            this.startTime = Integer.parseInt(startSplit[0])*60+Integer.parseInt(startSplit[1]);
            this.endTime = Integer.parseInt(endSplit[0])*60+Integer.parseInt(endSplit[1]);
            this.str = str;
            oct = oct.replaceAll("C#","c");
            oct = oct.replaceAll("D#","d");
            oct = oct.replaceAll("E#","e");
            oct =  oct.replaceAll("F#","f");
            oct = oct.replaceAll("G#","g");
            oct = oct.replaceAll("A#","a");
            this.oct = oct;
        }
        public boolean checkMusic(String checkStr){
            char[] chars = oct.toCharArray();
            int musicLen = this.oct.length();
            int time = this.endTime-this.startTime;
            int rep = time/musicLen;
            int namage = time%musicLen;
            String ans = "";
            for (int i = 0; i < rep; i++) {
                ans+=this.oct;
            }
            for (int i = 0; i <namage; i++) {
                ans+=chars[i];
            }
            System.out.println(ans);
            int i = ans.indexOf(checkStr);
            if(i!=-1) return true;

            return false;
        }

        @Override
        public int compareTo(Music o) {
            if(endTime-startTime<o.endTime-o.startTime)return 1;
            else if(endTime-startTime==o.endTime-o.startTime)return 0;
            return -1;
        }
    }
}

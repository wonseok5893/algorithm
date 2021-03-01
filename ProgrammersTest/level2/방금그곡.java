//package ProgrammersTest.level2;
//
//import java.util.*;
//
//public class 방금그곡 {
//    public static void main(String[] args) {
//        new 방금그곡().solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB, 13:00", "13:00,13:05,WORLD,ABCDEF"});
//    }
//    static Map<String, String> map;
//    public String solution(String m, String[] musicinfos) {
//        map = new HashMap<>();
//        map.put("C#","X");
//        map.put("D#","Y");
//        map.put("F#","Z");
//        map.put("G#","K");
//        map.put("A#","Q");
//
//        for (String s : map.keySet()) {
//           m =  m.replaceAll(s, map.get(s));
//        }
//
//        ArrayList<Music> lists = new ArrayList<>();
//        for (int i = 0; i < musicinfos.length; i++) {
//            lists.add(new Music(i, musicinfos[i]));
//        }
//        PriorityQueue<Music> queue = new PriorityQueue<>(new Comparator<Music>() {
//            @Override
//            public int compare(Music o1, Music o2) {
//                if(o1.playTime<o2.playTime)return 1;
//                else if(o1.playTime==o2.playTime){
//                    if(o2.idx<o1.idx)return 1;
//                    else if(o2.idx==o1.idx) return 0;
//                }
//                return -1;
//            }
//        });
//        for (Music music : lists) {
//            System.out.println(music);
//            if (music.containsOn(m)) {
//                queue.offer(music);
//            }
//        }
//        if(queue.size()==0)return"(None)";
//        else return queue.poll().title;
//    }
//
//    private class Music {
//        int idx;
//        int playTime;
//        String title;
//        String on;
//
//        public Music(int idx,String info) {
//            System.out.println(info);
//            this.idx =idx;
//            String[] split = info.split(",");
//
//            this.playTime = parseTime(split[1]) - parseTime(split[0]);
//
//
//            this.title = split[2];
//
//            for (String s : map.keySet()) {
//                split[3] =split[3].replaceAll(s, map.get(s));
//            }
//            int len = split[3].length();
//            String on = "";
//            for (int i = 0; i < this.playTime/len; i++) {
//                on+=split[3];
//            }
//            for (int i = 0; i < this.playTime%len; i++) {
//                on += split[3].charAt(i);
//            }
//
//            this.on = on;
//        }
//
//        public int parseTime(String time){
//            System.out.println("time: "+time);
//            int[] split = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
//            System.out.println(split[0]+ " " +split[1]);
//            return split[1]*60 - split[0];
//        }
//        public boolean containsOn(String m){
//           return this.on.contains(m);
//        }
//
//        @Override
//        public String toString() {
//            return "Music{" +
//                    "idx=" + idx +
//                    ", playTime=" + playTime +
//                    ", title='" + title + '\'' +
//                    ", on='" + on + '\'' +
//                    '}';
//        }
//    }
//}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;


class Solution {

    public String solution(String m, String[] musicinfos)  {


        m=m.replaceAll("C#","Z").replaceAll("D#","X").replaceAll("F#","V").replaceAll("G#","Y").replaceAll("A#","W");

        // 음악제목, 재생이시작되고 끝난 시간, 악보
        // [12:00,12:14,HELLO,CDEFGAB, 13:00,13:05,WORLD,ABCDEF]
        Music[] arr = new Music[musicinfos.length];

        for(int i=0;i<musicinfos.length;i++) {
            arr[i] = new Music(musicinfos[i], m);
        }

        ArrayList<Music> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i].check) {
                ans.add(arr[i]);
            }
        }

        Comparator<Music> comparator = new Comparator<Music>() {
            @Override
            public int compare(Music a, Music b) {
                // a.check가 참이고 b.check도 참이면
                // 노래가 재생되었을 경우 배열 앞으로 정렬
                if(a.check==true && b.check==false) {
                    return -1;
                }
                if (a.check==false && b.check==true) {
                    return 1;
                }
                if(a.check==b.check) { // a와 b가 둘다 재생되거나 재생되지 않았을경우 재생시간이 긴 기준으로 정렬
                    if(a.time>b.time) {
                        return -1;
                    }
                    else if(a.time==b.time) {
                        return 0;
                    }
                    else {
                        return 1;
                    }
                    // return b.time-a.time;
                }
                return 0;

                // return b.time-a.time;
            }
        };

        Arrays.sort(arr, comparator);
        // Collections.sort(ans, comparator);

        if(arr[0].check==true) {
            return arr[0].name;
        } else {
            return "(None)";
        }
//         if(ans.isEmpty()) {
//             return "(None)";
//         } else {
//             return ans.get(0).name;
//         }

    }

    class Music {

        String start;
        String end;
        String name;
        String sheet;
        int startTime;
        int endTime;

        int time;
        boolean check; // 노래가 재생되었는지 확인

        Music(String s, String m) {

            String[] temp = s.split(",");
            this.start = temp[0];
            this.end = temp[1];
            this.name = temp[2];
            this.sheet = temp[3];

            this.startTime = (Integer.parseInt(start.substring(0,2))*60)+Integer.parseInt(start.substring(3));
            this.endTime = (Integer.parseInt(end.substring(0,2))*60)+Integer.parseInt(end.substring(3));

            this.time = endTime-startTime;



            this.sheet = this.sheet.replaceAll("C#","Z").replaceAll("D#","X").replaceAll("F#","V")
                    .replaceAll("G#","Y").replaceAll("A#","W");

//             this.time = Integer.parseInt(end.substring(3))-Integer.parseInt(start.substring(3))+
//                 ((Integer.parseInt(end.substring(0,2))-Integer.parseInt(start.substring(0,2)))*60);

            this.check = compareSheet(m);

        }

        boolean compareSheet(String m) {

            StringBuilder builder = new StringBuilder();

            while(true) {
                if(builder.toString().length()>time) {
                    break;
                }
                builder.append(this.sheet);
            }

            String s = builder.toString().substring(0,time);

            if(s.contains(m))
                return true;
            return false;

        }

    }

}
package implement;

import java.util.*;

public class Programmers42579 {
    public static void main(String[] args) {
        int[] result = new  Programmers42579().solution(new String[]{"classic", "a", "b", "classic", "a", "classic"}, new int[]{10, 20, 20, 30, 40, 40});
        for (int e : result) {
            System.out.print(e + " ");
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, PriorityQueue<Music>> genreList = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            if (genreCount.get(genre) == null) {
                genreCount.put(genre, playCount);
            } else {
                int count = genreCount.get(genre);
                genreCount.put(genre, count + playCount);
            }
            if (genreList.get(genre) == null) {
                PriorityQueue<Music> musicList = new PriorityQueue<>();
                Music music = new Music(i, playCount);
                musicList.add(music);
                genreList.put(genre, musicList);
            } else {
                genreList.get(genre).offer(new Music(i, playCount));
            }
        }
        ArrayList<String> list = new ArrayList<>(genreCount.keySet());
        Collections.sort(list, (a, b) -> genreCount.get(b) - genreCount.get(a));

        ArrayList<Integer> result = new ArrayList<>();
        for (String e : list) {
            int count = 0;
            PriorityQueue<Music> queue = genreList.get(e);
            while (!queue.isEmpty() && count < 2) {
                Music music = queue.poll();
                result.add(music.num);
                count++;
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    class Music implements Comparable<Music> {
        int num;
        int count;

        Music(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Music other) {
            if (count < other.count) return 1;
            else if (count == other.count) {
                if (num > other.num) return 1;
            }
            return -1;
        }
    }
}


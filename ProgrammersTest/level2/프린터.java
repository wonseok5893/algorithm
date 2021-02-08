package ProgrammersTest.level2;

import java.util.ArrayList;
import java.util.Queue;

public class 프린터 {
    public static void main(String[] args) {

    }

    public int solution(int[] priorities, int location) {
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Task> finishedTasks = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            tasks.add(new Task((char) (i + 65), priorities[i]));
        }
        while (tasks.size() > 0) {
            Task remove = tasks.remove(0);
            // 꺼내
            if (check(tasks,remove.priority)) {
                //있으면
                tasks.add(remove);
            } else {
                finishedTasks.add(remove);
            }
        }

        int res = -1;
        for (int i = 0; i < finishedTasks.size(); i++) {
            if((int)finishedTasks.get(i).order==location+65)
            {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    private boolean check(ArrayList<Task> tasks,int value) {
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).priority>value)return true;
        }
        return false;
    }

    private class Task implements Comparable<Task> {
        char order;
        int priority;

        public Task(char order, int priority) {
            this.order = order;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task o) {
            return o.priority - priority;
        }
    }
}

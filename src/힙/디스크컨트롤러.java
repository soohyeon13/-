package 힙;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Job implements Comparable<Job> {
    int start;
    int workTime;

    public Job(int start, int workTime) {
        this.start = start;
        this.workTime = workTime;
    }

    @Override
    public int compareTo(Job o) {
        if (this.workTime < o.workTime) return -1;
        else if (this.workTime == o.workTime) {
            if (this.start < o.start) return -1;
            else return 1;
        }else return 1;
    }
}

class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Job> pq = new PriorityQueue<Job>();
        List<Job> list = new ArrayList<Job>();

        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Job(jobs[i][0], jobs[i][1]));
        }

        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }

        int time = 0;
        int sum = 0;

        while (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (time >= list.get(i).start) {
                    time += list.get(i).workTime;
                    sum += time - list.get(i).start;
                    list.remove(i);
                    break;
                }

                if (i == list.size() - 1) time++;
            }
        }
        answer = (sum / jobs.length);
        return answer;
    }
}

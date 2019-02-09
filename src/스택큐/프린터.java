package 스택큐;

import java.util.concurrent.LinkedBlockingQueue;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        LinkedBlockingQueue<Paper> q = new LinkedBlockingQueue<>();

        int i = 0;
        for (int p : priorities) {
            Paper pVO = new Paper();
            pVO.value = p;
            pVO.oriP = i;

            q.add(pVO);
            i++;
        }

        loop:
        while (!q.isEmpty()){
            Paper p = q.poll();

            for (Paper pp : q) {
                if (p.value < pp.value){
                    q.add(p);
                    continue loop;
                }
            }

            answer++;

            if (location == p.oriP){
                break;
            }
        }

        return answer;
    }

    class Paper {
        int value;
        int oriP;
    }
}

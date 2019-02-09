package 스택큐;


import java.util.LinkedList;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList<Integer> tr = new LinkedList<>();
        LinkedList<Integer> we = new LinkedList<>();
        LinkedList<Integer> br = new LinkedList<>();
        int current = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            tr.add(i);
        }
        while (!tr.isEmpty()) {
            if (we.size() <= bridge_length && current + tr.peek() <= weight) {
                current += tr.peek();
                we.add(tr.poll());
                br.add(0);
            }
            int bridege = br.size();
            for (int b = 0; b < bridege; b++) {
                br.add(br.poll() + 1);
            }
            if (br.size() == bridge_length) {
                br.poll();
                current -= we.poll();
            }
            answer++;
        }
        if (!br.isEmpty()) {
            int before = br.poll();
            answer += bridge_length - before + 1;

            while (!br.isEmpty()) {
                int temp = before - br.peek();
                answer += temp;
                before = br.poll();
            }
        }
        return answer;
    }
}

package 섬머코딩2017;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 1;
        int stateIndex = 0;

        while (true) {
            if (index >= stations[stateIndex] - w && index <= stations[stateIndex] + w) {
                index = stations[stateIndex] + w + 1;
                if (stateIndex < stations.length - 1) {
                    stateIndex++;
                }
            } else {
                index += w * 2 + 1;
                answer++;
            }
            if (index > n) {
                break;
            }
        }
        return answer;
    }
}

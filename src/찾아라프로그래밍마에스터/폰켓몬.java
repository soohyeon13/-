package 찾아라프로그래밍마에스터;

import java.util.HashMap;

//hashset 으로도 풀수 있다. hashset 도 공부하자
public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int index =1;

        map.put(nums[0],index);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }else {
                map.put(nums[i],index+1);
            }
        }

        if (map.size() > nums.length/2) {
            answer = nums.length/2;
        }else if (map.size() <= nums.length/2) {
            answer = map.size();
        }
        return answer;
    }
}

package 윈터코딩2018;

class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] mSkill;
        mSkill = skill.split("");

        for (String a : skill_trees) {
            int len = a.indexOf(mSkill[0]);
            for (int i = 1; i < mSkill.length; i++) {
                if (len == a.length()) {
                    answer++;
                    break;
                }
                if (len < a.indexOf(mSkill[i])) {
                    len = a.indexOf(mSkill[i]);
                }else if (len > a.indexOf(mSkill[i])){
                    break;
                }
            }
        }
            return answer;
    }
}

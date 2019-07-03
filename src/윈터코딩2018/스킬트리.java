package 윈터코딩2018;

class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int count = 0;

        for (String skills : skill_trees) {
            boolean classification = true;
            int index = 0;
            String[] mSkill = skills.split("");
            for (int i = 0; i < mSkill.length; i++) {
                if (index < skill.indexOf(mSkill[i])) {
                    classification = false;
                    break;
                } else if (index == skill.indexOf(mSkill[i])) {
                    index++;
                }
            }
            if (classification) {
                count += 1;
            }
        }

        answer = count;
        return answer;
    }
}

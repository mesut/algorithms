package algo4editions.chapter1;

import java.util.List;

public class RiverRecord {

    public static int maxTrailings(List<Integer> levels) {
        int maxTrailing = -1;
        for(int i = 0; i < levels.size(); i++) {
            int num = levels.get(i);
            for(int j = i - 1; j >= 0; j--) {
                int prevNum = levels.get(j);
                if (num >= prevNum) {
                    maxTrailing = Math.max(maxTrailing, num - prevNum);
                }
            }
        }
        return maxTrailing;
    }
}

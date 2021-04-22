package T1342;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numberOfSteps(20);
    }

    public int numberOfSteps (int num) {
        int result = step(num, 0);
        System.out.println(result);
        return result;
    }

    public int step(int num, int stepCount) {
        if (num == 0) {
            return stepCount;
        }
        while (true) {
            if (num == 0) {
                return stepCount;
            }
            if(num % 2 == 0) {
                stepCount++;
                num = num / 2;
                continue;
            }
            break;
        }
        num--;
        stepCount++;
        return step(num, stepCount);
    }
}

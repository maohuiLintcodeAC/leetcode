package T1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candies = new int[] {
                1,2,3,4,5,6
        };
        solution.kidsWithCandies(candies, 3);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>(candies.length);
        int max = getMax(candies) - extraCandies;
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] >= max ? true : false);
        }
//        System.out.println(result);
        return result;
    }

    private int getMax(int[] candies) {
        int max = 0;
        for (int i : candies) {
            if(max < i) {
                max = i;
            }
        }
        return max;
    }
}

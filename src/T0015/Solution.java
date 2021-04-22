package T0015;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        sort(nums, 0, nums.length-1);

        if (nums[0] > 0) {
            return result;
        }
        int left = 0;
        while (left < nums.length) {
            if (left > 0 && nums[left] == nums[left-1]) {
                left++;
                continue;
            }
            int i = left + 1;
            int right = nums.length - 1;
            while (i < right) {
                if (i > left + 1 && nums[i] == nums[i-1]) {
                    i++;
                    continue;
                }
                int sum = nums[left] + nums[i] + nums[right];
                if(sum == 0) {
                    List<Integer> element = new ArrayList<>();
                    element.add(nums[left]);
                    element.add(nums[i]);
                    element.add(nums[right]);
                    result.add(element);
                    i++;
                } else if (sum > 0) {
                    right--;
                } else {
                    i++;
                }
            }
            left++;
        }
        return result;
    }

    private void sort(int[] nums, int start, int end) {
        if (start == end) return;
        int left = start;
        int right = end;
        int target = nums[start];
        while (right > left) {
            while (right > left && nums[right] >= target) {
                right--;
            }

            while (right > left && nums[left] < target) {
                left++;
            }

            if (left == right) {
                left++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        sort(nums, start, left - 1);
        sort(nums, right + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                1,3,4,51,2,3,6,3,789,32,1,34,0,7,89,341,1,0, 2,323,12,3,1,0
        };

        Solution solution = new Solution();
        solution.threeSum(nums);
    }
}

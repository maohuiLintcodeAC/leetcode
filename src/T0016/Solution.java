package T0016;


/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        sort(nums, 0, nums.length - 1);
        int result = nums[0] + nums[1] + nums[2];
        int first = 0;

        while (first < nums.length - 1) {
            if (first - 1 > 0 && nums[first] == nums[first - 1]) {
                first++;
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    third--;
                } else {
                    second++;
                }
            }
            first++;
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
                -1,2,1,-4
        };

        Solution solution = new Solution();
        int result = solution.threeSumClosest(nums, 1);
        System.out.println(result);
    }
}

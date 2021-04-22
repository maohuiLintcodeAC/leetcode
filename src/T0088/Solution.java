package T0088;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (first >= 0 && second >= 0) {
                if (nums1[first] > nums2[second]) {
                    nums1[i] = nums1[first--];
                } else {
                    nums1[i] = nums2[second--];
                }
            } else if (first < 0) {
                nums1[i] = nums2[second--];
            } else {
                nums1[i] = nums1[first--];
            }
        }
    }

    public static void main(String[] args) {
        new Solution().merge(new int[] {
                1, 2, 3, 0, 0, 0
        }, 3, new int[] {
                2, 5, 6
        }, 3);
    }
}

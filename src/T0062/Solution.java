package T0062;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 输入：m = 3, n = 3
 * 输出：6
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int result = 0;
        int[][] dp = new int[m][n];
        result = resolve(dp, m - 1, n - 1);
        return result;
    }

    public int resolve(int[][] aim, int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m == 1 && n == 0) {
            return 1;
        }
        if (m == 0 && n ==1) {
            return 1;
        }
        if (m - 1 >= 0 && n-1 >= 0) {
            aim[m][n] = resolve(aim, m-1, n) + resolve(aim, m, n-1);
        } else if (m - 1 >= 0) {
            aim[m][n] = resolve(aim, m-1, n);
        } else {
            aim[m][n] = resolve(aim, m, n-1);
        }
        return aim[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.uniquePaths(3, 2);
        System.out.println(result);
    }
}
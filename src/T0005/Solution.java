package T0005;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }

        int[] result = new int[2];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            // 对角线为true, 也就是单个元素自己跟自己比对肯定是回文呀
            dp[i][i] = true;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i > result[1] - result[0]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return s.substring(result[0], result[1] + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.longestPalindrome("adfddsddff");
        System.out.println(result);
    }
}

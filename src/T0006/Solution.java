package T0006;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * [1, n]
 * %(4 + 4-2) == 0  第1行
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuffer[] result = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            result[i] = new StringBuffer();
        }

        int currentRow = 0;
        boolean downDirection = false;

        for (char c : s.toCharArray()) {
            result[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) downDirection = !downDirection;
            currentRow += downDirection ? 1 : -1;
        }

        StringBuffer sb = new StringBuffer();
        for (StringBuffer r : result) {
            sb.append(r);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convert("0123456789", 4);
        System.out.println(result);
    }
}

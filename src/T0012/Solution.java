package T0012;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String intToRoman(int num) {
        int q = num / 1000;
        int b = num / 100 % 10;
        int s = num / 10 % 10;
        int g = num % 10;

        StringBuffer sb = new StringBuffer();
        sb.append(convert(q, 4))
                .append(convert(b, 3))
                .append(convert(s, 2))
                .append(convert(g, 1));
        return sb.toString();
    }

    String convert(int i, int type) {
        String result = "";
        switch (type) {
            case 1:
                // 个位
                result = getChar(i, "I", "V", "X");
                break;
            case 2:
                // 十位
                result = getChar(i, "X", "L", "C");
                break;
            case 3:
                // 百位
                result = getChar(i, "C", "D", "M");
                break;
            case 4:
                // 千位
                result = getChar(i, "M", "", "");
                break;
        }
        return result;
    }

    String getChar(int i, String one, String five, String ten) {
        StringBuffer result = new StringBuffer();
        if (i < 4) {
            while (i-- > 0) {
                result.append(one);
            }
        } else if (i == 4) {
            result.append(one).append(five);
        } else if (i == 9) {
            result.append(one).append(ten);
        } else {
            result.append(five);
            while (i-- > 5) {
                result.append(one);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.intToRoman(1999);
        System.out.println(result);
    }
}
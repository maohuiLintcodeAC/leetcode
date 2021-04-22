package Huawei001;

public class Solution {
    public static int resolve(int num) {
        // f(n) = min(f(n + 1), fn(n - 1));
        int result = 0;
        if (num <= 1) {
            return 0;
        }
        if (num == 2) {
            return 1;
        }
        if (num % 2 == 0) {
            result += resolve(num / 2) + 1;
        } else {
            int i = resolve(num + 1) + 1;
            int j = resolve(num - 1) + 1;
            result += Math.min(i, j);
        }

        return result;
    }

    public static int resolve(int num, int[] dp) {
        // f(n) = min(f(n + 1), fn(n - 1));
        int result = 0;
        if (num <= 1) {
            return 0;
        }
        if (num == 2) {
            return 1;
        }
        if (dp[num] != 0) {
            return dp[num];
        }
        if (num % 2 == 0) {
            result += resolve(num / 2, dp) + 1;
        } else {
            int i = resolve(num + 1, dp) + 1;
            int j = resolve(num - 1, dp) + 1;
            result += Math.min(i, j);
        }
        dp[num] = result;
        return result;
    }


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int count = resolve(a);
//            System.out.println(count);
//        }

        int result = resolve(24, new int[25]);
        System.out.println(result);
    }
}


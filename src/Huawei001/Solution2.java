package Huawei001;

import java.util.Scanner;

public class Solution2 {
    public static int resolve(int[] value) {
        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            sum += value[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < value.length; i++) {
            for (int j = i + 1; j < value.length; j++) {
                for (int k = j + 1; k < value.length; k++) {
                    for (int l = k + 1; l < value.length; l++) {
                        for (int m = l + 1; m < value.length; m++) {
                            int v = value[i] + value[j] + value[k] + value[l] + value[m];
                            min = Math.min(Math.abs(v - (sum - v)), min);
                        }
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] v = new int[10];
        int index = 0;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            v[index++] = a;
        }
        int result = resolve(v);
        System.out.println(result);
    }
}

package com.jt61016.ocean.algorithm.dynamicprogramming;

/**
 * 最大子序列和
 *
 * @author jiangtao
 * @date 2018/10/10 下午2:49.
 */
public class MaxSubsequenceSum {
    final static int[] ARRAY = {1, -2, 4, -3, 5, -6};

    public static void main(String[] args) {
        int maxSum;

        maxSum = getMaxSubsequenceSumBF(ARRAY);
        System.out.println("getMaxSubsequenceSumBF : " + maxSum);

        maxSum = getMaxSubsequenceSumMBF(ARRAY);
        System.out.println("getMaxSubsequenceSumMBF : " + maxSum);

        maxSum = getMaxSubsequenceSumDP(ARRAY);
        System.out.println("getMaxSubsequenceSumDP : " + maxSum);

        maxSum = getMaxSubsequenceSumMDP(ARRAY);
        System.out.println("getMaxSubsequenceSumMDP : " + maxSum);
    }

    /**
     * Brute Force 蛮力法
     *
     * @param array 源序列
     * @return 最大子序列和
     */
    public static int getMaxSubsequenceSumBF(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int tmpSum;

        /**
         * i : 子序列长度
         * j : 子序列起始地址
         */
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i + 1; j++) {
                tmpSum = 0;
                for (int k = 0; k < i; k++) {
                    tmpSum += array[j + k];
                }
                if (maxSum < tmpSum) {
                    maxSum = tmpSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Majorizing Brute Force 改进蛮力法
     *
     * @param array 源序列
     * @return 最大子序列和
     */
    public static int getMaxSubsequenceSumMBF(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int tmpSum;

        for (int i = 0; i < array.length - 1; i++) {
            tmpSum = 0;
            for (int j = i; j <array.length - 1; j++) {
                tmpSum += array[j];
                if (maxSum < tmpSum) {
                    maxSum = tmpSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Dynamic Programming 动态规划
     *
     * @param array 源序列
     * @return 最大子序列和
     */
    public static int getMaxSubsequenceSumDP(int[] array) {
        int[] endMaxSum = new int[array.length];
        int[] tmpMaxSum = new int[array.length];

        endMaxSum[0] = tmpMaxSum[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            endMaxSum[i] = max(endMaxSum[i - 1] + array[i], array[i]);
            tmpMaxSum[i] = max(endMaxSum[i], tmpMaxSum[i - 1]);
        }

        return tmpMaxSum[array.length - 1];
    }

    /**
     * Majorizing Dynamic Programming 改进动态规划
     *
     * @param array 源序列
     * @return 最大子序列和
     */
    public static int getMaxSubsequenceSumMDP(int[] array) {
        int startPos = 0;
        int endPos = 0;

        int maxSum = array[0];
        int endMaxSum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (0 < endMaxSum) {
                endMaxSum += array[i];
                if (endMaxSum > maxSum) {
                    maxSum = endMaxSum;
                    endPos = i;
                }
            } else {
                endMaxSum = array[i];
                if (endMaxSum > maxSum) {
                    maxSum = endMaxSum;
                    startPos = i;
                    endPos = i;
                }
            }
        }
        System.out.println("From " + startPos + " to " + endPos);
        return maxSum;
    }

    private static int max(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }
}

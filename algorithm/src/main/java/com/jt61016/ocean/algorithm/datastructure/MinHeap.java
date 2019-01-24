package com.jt61016.ocean.algorithm.datastructure;

/**
 * 最小堆
 *
 * @author jiangtao
 * @date 2019/1/24 下午7:48.
 */
public class MinHeap {
    private static final int MAX_SIZE = 128;
    private Integer[] data = new Integer[MAX_SIZE];
    private int size = 0;

    /**
     * 添加元素
     * @param e 待添加元素
     */
    public void add(Integer e) {
        if (MAX_SIZE <= size) {
            throw new RuntimeException("overflow");
        }
        data[size] = e;
        size++;
        shiftUp(size - 1);
    }

    /**
     * 移除最小(即堆顶)元素
     *
     * @return 最小元素值
     */
    public int removeMin() {
        int min = data[0];
        data[0] = data[--size];
        shiftDown(0);
        return min;
    }

    /**
     * 获取(即堆顶)最小元素
     *
     * @return 最小元素值
     */
    public int getMin() {
        return data[0];
    }

    /**
     * 清空堆
     */
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * 元素k向上调整,维持最小堆
     *
     * @param k 需要调整的元素位置
     */
    private void shiftUp(int k) {
        while(k > 0) {
            int parentIndex = parentIndex(k);
            if (data[parentIndex] <= data[k]) {
                break;
            }
            swap(parentIndex, k);
            k = parentIndex;
        }
    }

    /**
     * 元素k向下调整,维持最小堆
     *
     * @param k 需要调整的元素位置
     */
    private void shiftDown(int k) {
        while (leftKidIndex(k) <= size) {
            int smallerKidIndex = leftKidIndex(k);
            if (rightKidIndex(k) <= size
                    && data[smallerKidIndex] > data[rightKidIndex(k)]) {
                smallerKidIndex = rightKidIndex(k);
            }
            if (data[smallerKidIndex] < data[k]) {
                swap(smallerKidIndex, k);
            }
            k = smallerKidIndex;
        }
    }

    private int parentIndex(int i) {
        return (i + 1 >> 1) - 1;
    }

    private int leftKidIndex(int i) {
        return (i << 1) + 1;
    }

    private int rightKidIndex(int i) {
        return (i << 1) + 2;
    }

    private void swap(int i, int j) {
        if (i >= size || j >= size) {
            throw new RuntimeException("overflow");
        }
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] test = {1, 2, 5, 12, 7, 17, 25, 19, 36, 99, 22, 28, 46, 92};
        MinHeap minHeap = new MinHeap();
        for (int i = 0; i < test.length; i++) {
            minHeap.add(test[i]);
        }
        System.out.println(minHeap.toString());
        minHeap.add(3);
        System.out.println(minHeap.toString());

        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.toString());
    }


}

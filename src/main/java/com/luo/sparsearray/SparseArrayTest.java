package com.luo.sparsearray;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : luo
 * @date : 2020/5/12
 * @description : 稀疏数组
 */
public class SparseArrayTest {

    /**
     * 创建并初始化一个原始二维数组
     * 0	0	1	0	8	0
     * 0	0	0	0	0	0
     * 0	0	0	3	0	0
     * 0	0	0	0	0	0
     * 0	0	0	0	0	6
     */
    int[][] ARRAY = new int[5][6];

    {
        ARRAY[0][2] = 1;
        ARRAY[0][4] = 8;
        ARRAY[2][3] = 3;
        ARRAY[4][5] = 6;
    }

    /**
     * 创建并初始化一个稀疏数组
     * 5    6   4
     * 0    2   1
     * 0    4   8
     * 2    3   3
     * 4    5   6
     */
    int[][] SPARSE_ARRAY = new int[5][3];

    {
        SPARSE_ARRAY[0][0] = 5;
        SPARSE_ARRAY[0][1] = 6;
        SPARSE_ARRAY[0][2] = 4;
        SPARSE_ARRAY[1][0] = 0;
        SPARSE_ARRAY[1][1] = 2;
        SPARSE_ARRAY[1][2] = 1;
        SPARSE_ARRAY[2][0] = 0;
        SPARSE_ARRAY[2][1] = 4;
        SPARSE_ARRAY[2][2] = 8;
        SPARSE_ARRAY[3][0] = 2;
        SPARSE_ARRAY[3][1] = 3;
        SPARSE_ARRAY[3][2] = 3;
        SPARSE_ARRAY[4][0] = 4;
        SPARSE_ARRAY[4][1] = 5;
        SPARSE_ARRAY[4][2] = 6;
    }

    @Test
    public void test1() {
        print2DArray(ARRAY);
    }

    /**
     * 二维数组转稀疏数组
     */
    @Test
    public void test2() {
        // 1. 遍历原始的二维数组，得到有效数据的个数sum
        int sum = 0;
        for (int[] row : ARRAY) {
            for (int i : row) {
                if (i > 0) {
                    sum++;
                }
            }
        }
        // 2. 根据sum创建稀疏数组spareArray int[sum + 1][3]，初始化第一行
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = ARRAY.length;
        sparseArray[0][1] = ARRAY[0].length;
        sparseArray[0][2] = sum;
        // 3. 将二维数组的有效数据存入到稀疏数组
        // 有效数组的个数
        int count = 1;
        for (int i = 0; i < ARRAY.length; i++) {
            for (int j = 0; j < ARRAY[0].length; j++) {
                if (ARRAY[i][j] > 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = ARRAY[i][j];
                    count++;
                }
            }
        }
        print2DArray(sparseArray);
    }

    /**
     * 稀疏数组转二维数组
     */
    @Test
    public void test3() {
        // 1. 先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组 array = >int[5][6]
        int[][] array = new int[SPARSE_ARRAY[0][0]][SPARSE_ARRAY[0][1]];
        // 2. 再读取稀疏数组后几行的数据并赋给原始的二维数组
        for (int i = 1; i < SPARSE_ARRAY.length; i++) {
            array[SPARSE_ARRAY[i][0]][SPARSE_ARRAY[i][1]] = SPARSE_ARRAY[i][2];
        }
        print2DArray(array);
    }

    private void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

}

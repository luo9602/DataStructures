package com.luo.stack;

/**
 * @author : Administrator
 * @date : 2020/5/18
 * @description :
 */
public interface Stack {

    /**
     * 栈是否满
     *
     * @return 是否满
     */
    boolean isFull();

    /**
     * 栈是否空
     *
     * @return 是否空
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param val 数据
     */
    void push(int val);

    /**
     * 出栈
     *
     * @return 数据
     */
    int pop();

    /**
     * 转数组
     *
     * @return 数组
     */
    int[] toArray();

}

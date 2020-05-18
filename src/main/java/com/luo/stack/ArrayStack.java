package com.luo.stack;

/**
 * @author : Administrator
 * @date : 2020/5/18
 * @description : 数组模拟栈
 */
public class ArrayStack implements Stack {

    /**
     * 栈的容量
     */
    private int maxSize;

    /**
     * 存储数据的数组
     */
    private int[] stack;

    /**
     * 栈顶 初始化为-1
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 栈是否满
     *
     * @return 是否满
     */
    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈是否空
     *
     * @return 是否空
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param val 数据
     */
    @Override
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        stack[++top] = val;
    }

    /**
     * 出栈
     *
     * @return 数据
     */
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stack[top--];
    }

    /**
     * 转数组
     *
     * @return 数组
     */
    @Override
    public int[] toArray() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int[] arr = new int[top + 1];
        int index = 0;
        for (int i = top; i >= 0; i--) {
            arr[index++] = stack[i];
        }
        return arr;
    }

}

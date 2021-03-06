package com.luo.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Administrator
 * @date : 2020/5/12
 * @description : 数组实现队列
 */
public class ArrayQueue implements Queue {

    /**
     * 最大容量
     */
    private int maxSize;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 用于存放数据的数组
     */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        // 指向队列头数据的前一个位置
        this.front = -1;
        // 指向队列尾数据的位置
        this.rear = -1;
    }

    @Override
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public void add(int i) {
        if (isFull()) {
            throw new RuntimeException("this queue is full");
        }
        // rear先后移再赋值
        this.arr[++rear] = i;
    }

    @Override
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        // 先后移再取数据
        return arr[++front];
    }

    @Override
    public int[] listQueue() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        int index = 0;
        int[] array = new int[size()];
        for (int i = front + 1; i <= front + size(); i++) {
            array[index++] = arr[i];
        }
        return array;
    }

    @Override
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        return arr[front + 1];
    }

    /**
     * 显示队列尾数据
     */
    @Override
    public int tail() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        return arr[rear];
    }

    @Override
    public int size() {
        return rear - front;
    }

}

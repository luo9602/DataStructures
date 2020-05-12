package com.luo.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Administrator
 * @date : 2020/5/12
 * @description : 数组实现队列
 */
public class ArrayQueue {

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

    /**
     * 队列是否满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 队列是否空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据, 入队
     */
    public void add(int i) {
        if (isFull()) {
            throw new RuntimeException("this queue is full");
        }
        // rear先后移再赋值
        this.arr[++rear] = i;
    }

    /**
     * 获取数据, 出队
     */
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        // 先后移再取数据
        return arr[++front];
    }

    /**
     * 显示队列全部数据
     */
    public int[] listQueue() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        return arr;
    }

    /**
     * 显示队列头数据
     */
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        return arr[front + 1];
    }

    /**
     * 显示队列尾数据
     */
    public int tail() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        return arr[rear];
    }

}

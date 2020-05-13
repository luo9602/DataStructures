package com.luo.queue;

/**
 * @author : Administrator
 * @date : 2020/5/13
 * @description : 数组实现环形队列
 */
public class CircleArrayQueue implements Queue {

    /**
     * 最大容量
     */
    private int maxSize;

    /**
     * 队列头 指向队列第一个元素 初始 0
     */
    private int front;

    /**
     * 队列尾 指向队列最后一个元素的后一位 初始 0
     */
    private int rear;

    /**
     * 用于存放数据的数组
     */
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }


    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = i;
        rear = (rear + 1) % maxSize;
    }

    @Override
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    @Override
    public int[] listQueue() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        int index = 0;
        int[] array = new int[size()];
        for (int i = front; i < front + size(); i++) {
            array[index++] = arr[i % maxSize];
        }
        return array;
    }

    @Override
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        return arr[front];
    }

    @Override
    public int tail() {
        if (isEmpty()) {
            throw new RuntimeException("this queue is empty");
        }
        return arr[(rear - 1 + maxSize) % maxSize];
    }

    @Override
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

}

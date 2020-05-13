package com.luo.queue;

/**
 * @author : Administrator
 * @date : 2020/5/13
 * @description :
 */
public interface Queue {

    /**
     * 队列是否满
     *
     * @return 是否满
     */
    boolean isFull();

    /**
     * 队列是否空
     *
     * @return 是否空
     */
    boolean isEmpty();

    /**
     * 添加数据, 入队
     *
     * @param i 入队数据
     */
    void add(int i);

    /**
     * 获取数据, 出队
     *
     * @return 出队数据
     */
    int get();

    /**
     * 显示队列全部数据
     *
     * @return 全部数据
     */
    int[] listQueue();

    /**
     * 显示队列头数据
     *
     * @return 头数据
     */
    int head();

    /**
     * 显示队列尾数据
     *
     * @return 尾数据
     */
    int tail();

    /**
     * 队列中有效数据的个数
     *
     * @return 个数
     */
    int size();

}

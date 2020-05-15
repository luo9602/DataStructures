package com.luo.linkedlist;

/**
 * @author : Administrator
 * @date : 2020/5/15
 * @description :
 */
public interface LinkedList<T> {

    /**
     * 获取头结点
     *
     * @return 头结点
     */
    T getHead();

    /**
     * 添加结点
     *
     * @param node 结点
     */
    void add(T node);

    /**
     * 顺序添加
     *
     * @param node 结点
     */
    void addByOrder(T node);

    /**
     * 修改
     *
     * @param node 待修改的结点
     */
    void update(T node);

    /**
     * 删除结点
     *
     * @param no 待删除的结点 no
     */
    void delete(int no);

    /**
     * 返回所有结点
     *
     * @return 结点的数组
     */
    T[] nodes();

    /**
     * 列表长度
     *
     * @return 长度
     */
    int size();

}

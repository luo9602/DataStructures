package com.luo.linkedlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Administrator
 * @date : 2020/5/15
 * @description :
 */
public class DoubleLinkedListTest {

    /**
     * 尾部添加
     */
    @Test
    public void test1() {
        LinkedList<DoubleNode> list = new DoubleLinkedList();
        list.add(new DoubleNode(1, 10));
        list.add(new DoubleNode(2, 20));
        list.add(new DoubleNode(4, 40));
        list.add(new DoubleNode(3, 30));
        System.out.println(Arrays.toString(list.nodes()));
    }

    /**
     * 顺序添加
     */
    @Test
    public void test2() {
        try {
            LinkedList<DoubleNode> list = new DoubleLinkedList();
            list.addByOrder(new DoubleNode(1, 10));
            list.addByOrder(new DoubleNode(2, 20));
            list.addByOrder(new DoubleNode(4, 40));
            list.addByOrder(new DoubleNode(3, 30));
            System.out.println(Arrays.toString(list.nodes()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

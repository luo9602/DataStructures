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

    /**
     * 修改结点
     */
    @Test
    public void test3() {
        try {
            LinkedList<DoubleNode> list = new DoubleLinkedList();
            list.addByOrder(new DoubleNode(1, 10));
            list.addByOrder(new DoubleNode(2, 20));
            list.addByOrder(new DoubleNode(4, 40));
            list.addByOrder(new DoubleNode(3, 30));
            System.out.println(Arrays.toString(list.nodes()));

            list.update(new DoubleNode(4, 50));
            System.out.println(Arrays.toString(list.nodes()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 删除结点
     */
    @Test
    public void test4() {
        try {
            LinkedList<DoubleNode> list = new DoubleLinkedList();
            list.addByOrder(new DoubleNode(1, 10));
            list.addByOrder(new DoubleNode(2, 20));
            list.addByOrder(new DoubleNode(4, 40));
            list.addByOrder(new DoubleNode(3, 30));
            System.out.println(Arrays.toString(list.nodes()));

            list.delete(4);
            System.out.println(Arrays.toString(list.nodes()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

package com.luo.linkedlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Administrator
 * @date : 2020/5/13
 * @description :
 */
public class SingleLinkedListTest {

    /**
     * 普通添加
     */
    @Test
    public void test1() {
        SingleLinkedList list = new SingleLinkedList();
        list.add(new Node(1, 10));
        list.add(new Node(2, 20));
        list.add(new Node(4, 40));
        list.add(new Node(3, 30));
        System.out.println(Arrays.toString(list.nodes()));
    }

    /**
     * 编号顺序添加
     */
    @Test
    public void test2() {
        SingleLinkedList list = new SingleLinkedList();
        try {
            list.addByOrder(new Node(1, 10));
            list.addByOrder(new Node(2, 20));
            list.addByOrder(new Node(4, 40));
            list.addByOrder(new Node(3, 30));
            System.out.println(Arrays.toString(list.nodes()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 编号顺序添加后修改
     * 倒数第 k 个结点
     */
    @Test
    public void test3() {
        SingleLinkedList list = new SingleLinkedList();
        try {
            list.addByOrder(new Node(1, 10));
            list.addByOrder(new Node(2, 20));
            list.addByOrder(new Node(4, 40));
            list.addByOrder(new Node(3, 30));
            System.out.println(Arrays.toString(list.nodes()));

            list.update(new Node(4, 50));
            System.out.println(Arrays.toString(list.nodes()));

            // 倒数第 k 个结点
            System.out.println(SingleLinkedList.findLastIndexNode(list.getHead(), 4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 编号顺序添加后删除
     */
    @Test
    public void test4() {
        SingleLinkedList list = new SingleLinkedList();
        try {
            list.addByOrder(new Node(1, 10));
            list.addByOrder(new Node(2, 20));
            list.addByOrder(new Node(4, 40));
            list.addByOrder(new Node(3, 30));
            System.out.println(Arrays.toString(list.nodes()));
            System.out.println(String.format("list size: %d", SingleLinkedList.getLength(list.getHead())));

            list.delete(2);
            list.delete(3);
            list.delete(1);
            System.out.println(Arrays.toString(list.nodes()));
            System.out.println(String.format("list size: %d", SingleLinkedList.getLength(list.getHead())));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 倒数第 k 个结点
     */
    @Test
    public void test5() {
        SingleLinkedList list = new SingleLinkedList();
        try {
            list.addByOrder(new Node(1, 10));
            list.addByOrder(new Node(2, 20));
            list.addByOrder(new Node(4, 40));
            list.addByOrder(new Node(3, 30));
            System.out.println(Arrays.toString(list.nodes()));
            // 倒数第 k 个结点
            System.out.println(SingleLinkedList.findLastIndexNode(list.getHead(), 4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 反转
     */
    @Test
    public void test6() {
        SingleLinkedList list = new SingleLinkedList();
        try {
            list.addByOrder(new Node(1, 10));
            list.addByOrder(new Node(2, 20));
            list.addByOrder(new Node(4, 40));
            list.addByOrder(new Node(3, 30));
            System.out.println(Arrays.toString(list.nodes()));
            // 反转
            SingleLinkedList.reverse(list.getHead());
            System.out.println(Arrays.toString(list.nodes()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 逆序打印 栈方式
     */
    @Test
    public void test7() {
        SingleLinkedList list = new SingleLinkedList();
        try {
            list.addByOrder(new Node(1, 10));
            list.addByOrder(new Node(2, 20));
            list.addByOrder(new Node(4, 40));
            list.addByOrder(new Node(3, 30));
            System.out.println(Arrays.toString(list.nodes()));
            SingleLinkedList.reversePrint(list.getHead());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

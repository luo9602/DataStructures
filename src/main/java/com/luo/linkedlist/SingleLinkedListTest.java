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

            list.update(new Node(5, 50));
            System.out.println(Arrays.toString(list.nodes()));
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
            System.out.println(String.format("list size: %d", list.size()));

            list.delete(2);
            list.delete(3);
            list.delete(1);
            System.out.println(Arrays.toString(list.nodes()));
            System.out.println(String.format("list size: %d", list.size()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

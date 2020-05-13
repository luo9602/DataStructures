package com.luo.linkedlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Administrator
 * @date : 2020/5/13
 * @description :
 */
public class LinkedListTest {

    @Test
    public void test1() {
        SingleLinkedList list = new SingleLinkedList();
        list.add(new Node(1, 10));
        list.add(new Node(2, 20));
        list.add(new Node(3, 30));
        System.out.println(Arrays.toString(list.nodes()));
    }

}

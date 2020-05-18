package com.luo.linkedlist;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Administrator
 * @date : 2020/5/18
 * @description :
 */
public class CircleLinkedListTest {

    /**
     * 添加
     */
    @Test
    public void test1() {
        CircleLinkedList list = new CircleLinkedList();
        list.add(5);
        System.out.println(Arrays.toString(list.nodes()));
    }

    @Test
    public void test2() {
        System.out.println(Arrays.toString(CircleLinkedList.outList(5, 1, 2)));
    }

}

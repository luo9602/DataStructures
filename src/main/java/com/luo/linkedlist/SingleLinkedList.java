package com.luo.linkedlist;

import java.util.LinkedList;

/**
 * @author : Administrator
 * @date : 2020/5/13
 * @description :
 */
public class SingleLinkedList {

    /**
     * 初始化头结点
     */
    private Node head = new Node(0, 0);

    /**
     * 长度
     */
    private int size;

    /**
     * 获取头结点
     *
     * @return 头结点
     */
    public Node getHead() {
        return head;
    }

    /**
     * 添加结点
     *
     * @param node 结点
     */
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    public Node[] nodes() {
        Node[] arr = new Node[size];
        if (head.next == null) {
            throw new RuntimeException("list is empty");
        }
        int index = 0;
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            arr[index++] = temp.next;
            temp = temp.next;
        }
        return arr;
    }

}

class Node {

    int no;

    int val;

    Node next;

    Node(int no, int val) {
        this.no = no;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", val=" + val +
                '}';
    }

}

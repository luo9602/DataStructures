package com.luo.stack;


import com.luo.linkedlist.SingleLinkedList;
import javafx.beans.binding.When;

/**
 * @author : Administrator
 * @date : 2020/5/18
 * @description : 使用单链表模拟栈
 */
public class SingleLinkedListStack implements Stack {

    /**
     * 栈的容量
     */
    private int maxSize;

    /**
     * 栈顶
     */
    private int top = -1;

    /**
     * 单链表存储数据
     */
    private Node head;

    public SingleLinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        head = new Node(-1);
    }

    /**
     * 查看栈顶数据
     *
     * @return 栈顶
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return head.next.val;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        Node node = new Node(val);
        if (head.next == null) {
            head.next = node;
        } else {
            node.next = head.next;
            head.next = node;
        }
        top++;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Node temp = head.next;
        int val = temp.val;
        head.next = temp.next;
        top--;
        return val;
    }

    @Override
    public int[] toArray() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int[] arr = new int[top + 1];
        Node temp = head.next;
        int index = 0;
        while (temp != null) {
            arr[index++] = temp.val;
            temp = temp.next;
        }
        return arr;
    }

}

class Node {

    int val;

    Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

}

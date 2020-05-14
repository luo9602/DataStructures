package com.luo.linkedlist;

import java.util.LinkedList;

/**
 * @author : Administrator
 * @date : 2020/5/13
 * @description : 单链表
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
        // 从头结点开始遍历
        Node temp = head;
        while (temp.next != null) {
            // 移动 temp 的位置
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    /**
     * 根据 node 的 no 按顺序添加
     *
     * @param node 结点
     */
    public void addByOrder(Node node) {
        // 根据待添加 node 的 no 找到添加位置的前一个结点
        // 从头结点开始遍历
        Node temp = head;
        // 添加标志 待添加 node 的 no 是否存在
        boolean flag = false;
        while (true) {
            // 下一个结点为 null
            if (temp.next == null) {
                break;
            }
            // 待添加的位置 temp node temp.next
            if (temp.next.no > node.no) {
                break;
            }
            // 待添加位置已存在
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            // 移动 temp 的位置
            temp = temp.next;
        }
        if (flag) {
            throw new RuntimeException(String.format("node(%d) exists", node.no));
        } else {
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    /**
     * 根据 node 的 no 修改 node 的 val
     *
     * @param node 待修改的结点
     */
    public void update(Node node) {
        if (head.next == null || size() == 0) {
            throw new RuntimeException("list is empty");
        }
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.val = node.val;
        } else {
            throw new RuntimeException(String.format("node(%d) doesn't exist", node.no));
        }
    }

    /**
     * 删除结点
     *
     * @param no 待删除的结点 no
     */
    public void delete(int no) {
        if (head.next == null || size() == 0) {
            throw new RuntimeException("list is empty");
        }
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            size--;
        } else {
            throw new RuntimeException(String.format("node(%d) doesn't exist", no));
        }
    }

    /**
     * 返回所有结点
     *
     * @return 结点的数组
     */
    public Node[] nodes() {
        if (head.next == null || size() == 0) {
            throw new RuntimeException("list is empty");
        }
        Node[] arr = new Node[size];
        int index = 0;
        Node temp = head;
        while (temp.next != null) {
            arr[index++] = temp.next;
            temp = temp.next;
        }
        return arr;
    }

    /**
     * 列表长度
     *
     * @return 长度
     */
    public int size() {
        return size;
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
        return "Node{" + "no=" + no + ", val=" + val + '}';
    }

}

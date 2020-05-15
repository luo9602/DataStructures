package com.luo.linkedlist;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

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

    /**
     * 获取有效结点的个数(不包含头结点)
     *
     * @param head 头结点
     * @return 个数
     */
    public static int getLength(Node head) {
        if (head.next == null) {
            return 0;
        }
        int count = 0;
        Node temp = head.next;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 查找单链表中的倒数第k个结点
     *
     * @param head  头结点
     * @param index k
     * @return 所查找的结点
     */
    public static Node findLastIndexNode(Node head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            throw new RuntimeException("size illegal");
        }
        Node temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 单链表的反转
     *
     * @param head 头结点
     */
    public static void reverse(Node head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 定义一个新的头结点
        Node reverseHead = new Node(0, 0);
        // 从头结点的下一个结点开始遍历
        Node temp = head.next;
        // 用来保存 temp 的 next 结点
        Node next;
        // 遍历原单链表, 将原链表的每一个结点取出, 并放在 reverseHead 后的第一个位置
        while (temp != null) {
            // 保存遍历结点的后一个结点
            next = temp.next;
            // 将原链表结点放在 reverseHead 后的第一个位置
            // 相当于两个链表 head 后的所有结点相互交换
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            // 后移
            temp = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 逆序打印单链表 栈方式
     *
     * @param head 头结点
     */
    public static void reversePrint(Node head) {
        if (head.next == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = head.next;
        // 入栈
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        // 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
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

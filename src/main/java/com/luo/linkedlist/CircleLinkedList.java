package com.luo.linkedlist;

/**
 * @author : Administrator
 * @date : 2020/5/18
 * @description : 约瑟夫问题实现 环形单链表
 */
public class CircleLinkedList {

    private CircleNode first = null;

    private int size;

    /**
     * 添加结点
     *
     * @param num 添加的个数
     */
    public void add(int num) {
        if (num < 1) {
            throw new RuntimeException("num error");
        }
        this.size = num;
        // 辅助指针,用于构建环形链表,指向尾结点
        CircleNode rear = null;
        for (int i = 1; i <= num; i++) {
            // 根据编号创建结点
            CircleNode node = new CircleNode(i);
            // 如果是第一个结点
            if (i == 1) {
                first = node;
                // 构成环
                first.next = first;
                // curNode指向第一个结点
                rear = first;
            } else {
                rear.next = node;
                node.next = first;
                // 后移
                rear = node;
            }
        }
    }

    /**
     * 返回所有结点
     *
     * @return 所有结点
     */
    public CircleNode[] nodes() {
        // 是否为空
        if (first == null) {
            throw new RuntimeException("list is empty");
        }
        CircleNode[] nodes = new CircleNode[size];
        // first 不能动, 通过 temp 遍历链表
        CircleNode temp = first;
        int index = 0;
        while (true) {
            nodes[index++] = temp;
            // first 1 2 3 ... temp
            if (temp.next == first) {
                break;
            }
            // 后移
            temp = temp.next;
        }
        return nodes;
    }

    /**
     * 编号为1，2，...n的n个人围坐一圈
     * 编号为k（1<=k<=n）的人从1开始报数，数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，
     * 直到所有人出列为止，由此产生一个出队编号的序列
     *
     * @param n 总人数
     * @param k 起始编号
     * @param m 数到m
     * @return 编号
     */
    public static CircleNode[] outList(int n, int k, int m) {
        if (k < 1 || k > n) {
            throw new RuntimeException("param error");
        }
        CircleNode[] result = new CircleNode[n];
        // 创建环形链表
        CircleLinkedList list = new CircleLinkedList();
        list.add(n);
        // 报数前移动 first 至指定位置
        for (int i = 0; i < k - 1; i++) {
            list.first = list.first.next;
        }
        // 辅助指针指向 first 的前一个结点
        CircleNode temp = list.first;
        while (temp.next != list.first) {
            temp = temp.next;
        }
        int index = 0;
        // 报数开始, first 和 temp 同时移动 m - 1 次, 然后将 first 指向的结点移出链表, 直到链表中只有一个结点
        // first = temp 时链表中只有一个结点
        while (temp != list.first) {
            // first 和 temp 同时移动 m - 1 次
            for (int i = 0; i < m - 1; i++) {
                list.first = list.first.next;
                temp = temp.next;
            }
            // 此时 first 指向的结点即为需要移出链表的结点
            // 将 first 移出链表
            result[index++] = list.first;
            list.first = list.first.next;
            temp.next = list.first;
        }
        // 最后一个结点
        result[index] = temp;
        return result;
    }

}

class CircleNode {

    int no;

    CircleNode next;

    public CircleNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "no=" + no +
                '}';
    }

}
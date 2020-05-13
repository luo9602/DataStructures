package com.luo.queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Administrator
 * @date : 2020/5/12
 * @description :
 */
public class QueueTest {

    /**
     * 数组实现队列
     */
    @Test
    public void test1() {
//        Queue queue = new ArrayQueue(3);
        Queue queue = new CircleArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean flag = true;
        while (flag) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头数据");
            System.out.println("t(tail): 查看队列尾数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        System.out.println(Arrays.toString(queue.listQueue()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    flag = false;
                    break;
                case 'a':
                    System.out.println("输入需要添加的数据");
                    try {
                        queue.add(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("取出数据:" + queue.get());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("队列头数据:" + queue.head());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 't':
                    try {
                        System.out.println("队列尾数据:" + queue.tail());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
        System.out.println("退出程序");
    }

}

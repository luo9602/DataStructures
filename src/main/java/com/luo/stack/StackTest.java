package com.luo.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Administrator
 * @date : 2020/5/18
 * @description :
 */
public class StackTest {

    @Test
    public void test1() {
//        Stack stack = new ArrayStack(5);
        Stack stack = new SingleLinkedListStack(5);
        char key = ' ';
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("s(show): 显示栈");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 入栈");
            System.out.println("g(get): 出栈");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        System.out.println(Arrays.toString(stack.toArray()));
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
                        stack.push(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("取出数据:" + stack.pop());
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

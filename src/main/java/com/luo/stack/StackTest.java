package com.luo.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.spi.ResourceBundleControlProvider;

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

    @Test
    public void test2() {
        Calculator calculator = new Calculator();
        int res = calculator.calculate("14+22/1-1");
        System.out.println(res);
    }

    /**
     * 逆波兰表达式计算
     */
    @Test
    public void test3() {
        int res = ReversePolishNotationCalculator.calSuffixExpression("3 4 + 5 * 6 -");
        System.out.println(res);
    }

    /**
     * 中缀表达式转list
     */
    @Test
    public void test4() {
        List<String> list =
                ReversePolishNotationCalculator.toInfixExpressionList("211*3-(23+1231)/12312313+(526456-685985)-2122232");
        list.forEach(System.out::print);
    }

    /**
     * 中缀表达式转后缀表达式
     */
    @Test
    public void test5() {
        List<String> list =
                ReversePolishNotationCalculator.inFixExpression2SuffixList("1+((2+3)*4)-5");
        list.forEach(System.out::print);
        System.out.println();
    }

    /**
     * 中缀表达式计算
     */
    @Test
    public void test6() {
        System.out.println(ReversePolishNotationCalculator.calculate("1+((2+3)*4)-5"));
    }

}

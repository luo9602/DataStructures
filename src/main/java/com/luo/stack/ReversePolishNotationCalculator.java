package com.luo.stack;

import java.util.Stack;

/**
 * @author : Administrator
 * @date : 2020/5/19
 * @description : 逆波兰表达式运算
 */
public class ReversePolishNotationCalculator {

    /**
     * 计算
     *
     * @param suffixExpression 后缀表达式
     * @return 结果
     */
    public static int calculate(String suffixExpression) {
        String[] strArr = suffixExpression.split(" ");
        Stack<String> stack = new Stack<>();
        for (String str : strArr) {
            // 匹配多位数
            if (str.matches("\\d+")) {
                stack.push(str);
            }
            // 运算符
            else {
                // pop两个数并运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                switch (str) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("oper error");
                }
                // 运算结构入栈
                stack.push(String.valueOf(res));
            }
        }
        // 返回结果
        return Integer.parseInt(stack.pop());
    }

}

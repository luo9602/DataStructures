package com.luo.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Administrator
 * @date : 2020/5/19
 * @description : 逆波兰表达式运算
 */
public class ReversePolishNotationCalculator {

    public static List<String> parseSuffixExpressionList(List<String> infixList) {
        // 定义两栈

        return null;
    }

    /**
     * 将中缀表达式字符串转为 list
     *
     * @param infixExpression 中缀表达式字符串
     * @return list
     */
    public static List<String> toInfixExpressionList(String infixExpression) {
        List<String> infixList = new ArrayList<>();
        // 表达式长度
        int length = infixExpression.length();
        int index = 0;
        // 多位数拼接
        StringBuilder longNum;
        // 遍历到的字符
        char ch;
        while (index < length) {
            // 遍历字符
            ch = infixExpression.charAt(index);
            // 非数字直接存入 list 中
            if (ch < 48 || ch > 57) {
                infixList.add(String.valueOf(ch));
                index++;
            } else {
                longNum = new StringBuilder();
                while (ch >= 48 && ch <= 57) {
                    longNum.append(ch);
                    index++;
                    if (index > length - 1) {
                        break;
                    }
                    ch = infixExpression.charAt(index);
                }
                infixList.add(String.valueOf(longNum));
            }
        }
        return infixList;
    }

    /**
     * 计算
     *
     * @param suffixExpression 后缀表达式字符串
     * @return 结果
     */
    @Deprecated
    public static int calSuffixExpression(String suffixExpression) {
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

/**
 * 运算符对应的优先级
 */
class Operation {

    /**
     * 返回对应的优先级数字
     *
     * @param operation 运算符
     * @return 优先级
     */
    public static int getPriority(String operation) {
        int result;
        int add = 1, sub = 1;
        int mul = 2, div = 2;
        switch (operation) {
            case "+":
                result = add;
                break;
            case "-":
                result = sub;
                break;
            case "*":
                result = mul;
                break;
            case "/":
                result = div;
                break;
            default:
                throw new RuntimeException("不存在该运算符:" + operation);
        }
        return result;
    }

}

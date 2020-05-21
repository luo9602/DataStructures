package com.luo.stack;

import org.w3c.dom.ls.LSException;

import java.util.*;
import java.util.Stack;

/**
 * @author : Administrator
 * @date : 2020/5/19
 * @description : 逆波兰表达式运算
 */
public class ReversePolishNotationCalculator {

    /**
     * 计算中缀表达式 (先将中缀表达式转为逆波兰表达式再计算)
     *
     * @param infixExpression 中缀表达式
     * @return 结果
     */
    public static int calculate(String infixExpression) {
        return cal(inFixExpression2SuffixList(infixExpression));
    }

    /**
     * 计算逆波兰表达式
     *
     * @param suffixExpression 逆波兰表达式字符串
     * @return 结果
     */
    @Deprecated
    public static int calSuffixExpression(String suffixExpression) {
        return cal(Arrays.asList(suffixExpression.split(" ")));
    }

    /**
     * 计算方法
     *
     * @param suffixList 逆波兰表达式list
     * @return 结果
     */
    private static int cal(List<String> suffixList) {
        Stack<String> stack = new Stack<>();
        for (String str : suffixList) {
            // 数字
            if (str.matches("\\d+")) {
                stack.push(str);
            }
            // 运算符
            else {
                int top = Integer.parseInt(stack.pop());
                int secondTop = Integer.parseInt(stack.pop());
                int res;
                switch (str) {
                    case "+":
                        res = secondTop + top;
                        break;
                    case "-":
                        res = secondTop - top;
                        break;
                    case "*":
                        res = secondTop * top;
                        break;
                    case "/":
                        res = secondTop / top;
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

    /**
     * 中缀表达式字符串转逆波兰表达式list
     *
     * @param infixExpression 中缀表达式字符串
     * @return 逆波兰表达式list
     */
    public static List<String> inFixExpression2SuffixList(String infixExpression) {
        return parseSuffixExpressionList(toInfixExpressionList(infixExpression));
    }

    /**
     * 中缀表达式list转逆波兰表达式list
     *
     * @param infixList 中缀表达式list
     * @return 逆波兰表达式list
     */
    public static List<String> parseSuffixExpressionList(List<String> infixList) {
        String leftParenthesis = "(";
        String rightParenthesis = ")";
        // 定义两个栈, 运算符栈s1 和 存储中间结果栈s2
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        // 遍历中缀表达式list
        for (String str : infixList) {
            // 数字直接入 s2栈
            if (str.matches("\\d+")) {
                s2.push(str);
            }
            // 左括号
            else if (leftParenthesis.equals(str)) {
                s1.push(str);
            }
            // 右括号
            else if (rightParenthesis.equals(str)) {
                // 将 s1栈 中的数据一次弹出入 s2栈, 直到遇到左括号为止
                // 再弹出 s1 中的这个左括号, 消除这一对括号
                while (!leftParenthesis.equals(s1.peek())) {
                    s2.push(s1.pop());
                }
                // 弹出左括号
                s1.pop();
            }
            // 其他运算符
            else {
                // 1. 如果 s1栈为空, 或栈顶运算符为左括号, 则直接将此运算符入栈
                // 2. 否则, 若优先级比 s1栈顶运算符的高, 也将运算符入 s1栈
                // 3. 否则, 将 s1栈顶的运算符弹出并入 s2栈, 再次重复步骤（1）与 s1中新的栈顶运算符相比较
                if (!s1.isEmpty() && !leftParenthesis.equals(s1.peek())) {
                    if (Operation.getPriority(str) <= Operation.getPriority(s1.peek())) {
                        while (!s1.isEmpty() && !leftParenthesis.equals(s1.peek()) && Operation.getPriority(s1.peek()) >= Operation.getPriority(str)) {
                            s2.push(s1.pop());
                        }
                    }
                }
                //还需要将item压入栈
                s1.push(str);
            }
        }
        // 将 s1栈 中剩余的运算符依次弹出并入 s2栈
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return new ArrayList<>(s2);
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

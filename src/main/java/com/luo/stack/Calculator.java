package com.luo.stack;

/**
 * @author : Administrator
 * @date : 2020/5/19
 * @description : 简单的加减乘除计算器, 两位数, 不包含括号, 注意减法的位置, 后续完善
 */
public class Calculator {

    /**
     * 计算
     *
     * @param expression 表达式
     * @return 结果
     */
    public int calculate(String expression) {
        // 1. 创建 数栈 和 符号栈
        Stack numStack = new ArrayStack(10);
        Stack operStack = new ArrayStack(10);
        // 2. 通过index遍历表达式
        int num1 = 0, num2 = 0, oper = 0, res = 0;
        // 遍历到的字符
        char ch = ' ';
        // 存放多位数的字符串
        StringBuilder longNum = new StringBuilder();
        int index = 0;
        int length = expression.length();
        while (index < length) {
            // 获取遍历到的字符
            ch = expression.charAt(index);
            // 3. 遍历到操作符
            if (isOper(ch)) {
                // 符号栈 为空，直接入 符号栈
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                }
                // 符号栈 不为空
                else {
                    // 如果当前操作符的优先级大于栈中操作符, 直接入 符号栈
                    if (priority(ch) > priority(operStack.peek())) {
                        operStack.push(ch);
                    }
                    // 如果当前操作符的优先级小于或等于栈中操作符
                    else {
                        // 从 数栈 中pop出两个数字
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        // 从 符号栈 中pop出一个操作符进行运算
                        oper = operStack.pop();
                        res = cal(num1, num2, oper);
                        // 然后将结果入‘数’栈
                        numStack.push(res);
                        // 将当前操作符入‘符号’栈
                        operStack.push(ch);
                    }
                }
            }
            // 4. 遍历到数字直接入 数栈
            else {
                longNum.append(ch);
                // 如果为最后一位直接入栈
                if (index == length - 1) {
                    numStack.push(Integer.parseInt(longNum.toString()));
                } else {
                    // 下一位为操作符
                    if (isOper(expression.charAt(index + 1))) {
                        // 直接入栈
                        numStack.push(Integer.parseInt(longNum.toString()));
                        // 清空多位数
                        longNum = new StringBuilder();
                    }
                }
            }
            index++;
        }
        // 5. 遍历结束后, 顺序的从 数栈 和 符号栈 中pop出数字和符号进行运算, 运算结果入 数栈
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = cal(num1, num2, oper);
            numStack.push(res);
        }
        // 6. 最后 数栈 中只有一个数字
        res = numStack.pop();
        return res;
    }

    /**
     * 是否运算符
     *
     * @param oper 符号
     * @return 是否运算符
     */
    public static boolean isOper(int oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    /**
     * 返回运算符的优先级
     *
     * @param oper 运算符
     * @return 优先级
     */
    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 计算
     *
     * @param num1 数字1
     * @param num2 数字2
     * @param oper 运算符
     * @return 结果
     */
    public static int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}

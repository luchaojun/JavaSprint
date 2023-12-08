package com.wistron.stack;

import java.util.Stack;

/**
 * @Author：Chaojun_Lu
 * @Date：2023/12/8 23:26
 * @Function： Stack的测试和使用
 */
public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
    }
}

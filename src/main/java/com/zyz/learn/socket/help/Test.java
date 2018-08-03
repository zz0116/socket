package com.zyz.learn.socket.help;

import java.util.Arrays;

/**
 * @author ZhangYuanzhuo
 * @since 2017/10/31
 */
public class Test {
    public static void main(String[] args) {
        byte[] bytes = {-69, -68, 5, 6, 0};
//        System.out.println(Arrays.toString(bytes));
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]);
//        }
        String s = new String(bytes);
        int size = Integer.parseInt(s);
        System.out.println(size);
    }
}

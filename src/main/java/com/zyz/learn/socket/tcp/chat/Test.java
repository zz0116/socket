package com.zyz.learn.socket.tcp.chat;

import java.util.Scanner;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/5
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        new Thread(() -> {
            while (in.hasNext()) {
                System.out.println("out: " + in.next());
            }
        }).start();
        new Thread(() -> {
            System.out.println("会被阻塞吗？");
        }).start();
    }
}

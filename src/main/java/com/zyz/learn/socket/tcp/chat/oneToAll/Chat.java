package com.zyz.learn.socket.tcp.chat.oneToAll;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/4
 */
public class Chat {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            Socket socket;
            socket = new Socket("127.0.0.1", 8888);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String s;
            while (!"bye".equals(s = in.next())) {
                dos.writeUTF(s);
                dos.flush();
            }
            dos.writeUTF(s);
            dos.flush();

            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

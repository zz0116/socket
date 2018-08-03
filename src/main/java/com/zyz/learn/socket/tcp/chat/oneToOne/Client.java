package com.zyz.learn.socket.tcp.chat.oneToOne;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/4
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 6666);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.next();
            if ("bye".equals(s)) {
                break;
            }
            dos.writeUTF(s);
            dos.flush();
            System.out.println("Server: " + dis.readUTF());
        }

        dos.close();
        dis.close();
        socket.close();
    }
}

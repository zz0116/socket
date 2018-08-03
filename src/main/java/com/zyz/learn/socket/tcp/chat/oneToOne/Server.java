package com.zyz.learn.socket.tcp.chat.oneToOne;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/4
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket socket = ss.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Client: " + dis.readUTF());
            String s = in.next();
            if ("bye".equals(s)) {
                break;
            }
            dos.writeUTF(s);
            dos.flush();
        }

        dis.close();
        dos.close();
        socket.close();
        ss.close();
    }
}

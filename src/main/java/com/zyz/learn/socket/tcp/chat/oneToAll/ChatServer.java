package com.zyz.learn.socket.tcp.chat.oneToAll;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/4
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Set<Socket> sockets = new HashSet<>();

        do {
            try {
                // 主线程在ss关闭前提前到达这一步等待，所以需要catch服务器已关闭的异常
                Socket socket = ss.accept();
                if (sockets.add(socket)) {
                    new Thread(() -> {
                        int port = socket.getPort();
                        InetAddress inetAddress = socket.getInetAddress();
                        try {
                            System.out.println(inetAddress + "#" + port + " 登录了！");
                            DataInputStream dis = new DataInputStream(socket.getInputStream());
                            String s;
                            while (!"bye".equals(s = dis.readUTF())) {
                                System.out.println(inetAddress + "#" + port + ": " + s);
                            }
                            System.out.println(inetAddress + "#" + port + " 下线了！");

                            dis.close();
                            socket.close();
                            sockets.remove(socket);
                            if (sockets.isEmpty()) {
                                ss.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (SocketException e) {
                System.out.println("没有连接，服务器关闭！");
                break;
            }
        } while (true);

    }
}

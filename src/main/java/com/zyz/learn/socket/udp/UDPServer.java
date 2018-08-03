package com.zyz.learn.socket.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/5
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        // 1
//        byte[] buf = new byte[1024];
//        DatagramPacket dp = new DatagramPacket(buf, buf.length);
//        DatagramSocket ds = new DatagramSocket(5678);
//        while (true) {
//            ds.receive(dp);
//            System.out.println(new String(buf, 0, dp.getLength()));
//        }

        // 2
//        byte[] buf = new byte[1024];
//        DatagramPacket dp = new DatagramPacket(buf, buf.length);
//        DatagramSocket ds = new DatagramSocket(5678);
//        while (true) {
//            ds.receive(dp);
//            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
//            DataInputStream dis = new DataInputStream(bais);
//            System.out.println(dis.readLong());
//        }

        // 3 聊天
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        DatagramSocket ds = new DatagramSocket(5678);
        while (true) {
            ds.receive(dp);

            String s = new String(buf, 0, dp.getLength());
            int port = dp.getPort();

            System.out.println(port + ": " + s);
            if ("bye".equals(s)) {
                System.out.println(port + " 下线了！");
            }
        }
    }
}

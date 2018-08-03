package com.zyz.learn.socket.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/5
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        // 1
//        byte[] buf = (new String("Hello")).getBytes();
//        DatagramPacket dp = new DatagramPacket(buf, buf.length,
//                new InetSocketAddress("127.0.0.1", 5678));
//        DatagramSocket ds = new DatagramSocket(9999);
//        ds.send(dp);
//        ds.close();

        // 2 发送long类型的数
//        long l = 12345678L;
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        DataOutputStream dos = new DataOutputStream(baos);
//        dos.writeLong(l);
//        byte[] buf = baos.toByteArray();
//        DatagramPacket dp = new DatagramPacket(buf, buf.length,
//                new InetSocketAddress("127.0.0.1", 5678));
//        DatagramSocket ds = new DatagramSocket(9999);
//        ds.send(dp);
//        ds.close();

        // 3 聊天
        Scanner in = new Scanner(System.in);
        DatagramPacket dp;
        DatagramSocket ds = new DatagramSocket((int) (Math.random()*10000) + 1024);
        String s;
        while (true) {
            byte[] buf = (s = in.next()).getBytes();
            dp = new DatagramPacket(buf, buf.length,
                    new InetSocketAddress("127.0.0.1", 5678));
            ds.send(dp);

            if ("bye".equals(s)) {
                break;
            }
        }
        ds.close();
    }
}

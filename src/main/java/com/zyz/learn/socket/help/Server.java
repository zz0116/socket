package com.zyz.learn.socket.help;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/4
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);

        // 1 client连接上，发送消息，server接收消息
//        while (true) {
//            Socket s = ss.accept();
//            DataInputStream dis = new DataInputStream(s.getInputStream());
//            System.out.println(dis.readUTF());
//            dis.close();
//            s.close();
////            System.out.println("A client connect!");
//        }

        // 2 client连接上，server发送消息，client接收消息
//        while (true) {
//            Socket s = ss.accept();
//            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//            dos.writeUTF("Hello, " + s.getInetAddress() + "port#" + s.getPort() + ", bye!");
//            dos.close();
//            s.close();
//        }

        // 3 两边都发送消息和接收消息
//        Socket socket = ss.accept();
//        DataInputStream dis = new DataInputStream(socket.getInputStream());
//        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//        String s;
//        if ((s = dis.readUTF()) != null) {
//            System.out.println(s);
//            System.out.println("from: " + socket.getInetAddress());
//            System.out.println("port: " + socket.getPort());
//        }
//        dos.writeUTF("hello!");
//        dis.close();
//        dos.close();
//        socket.close();

        // 4 多线程
//        while (true) {
//            new Thread(() -> {
//                try {
//                    Socket s = ss.accept();
//                    System.out.println(s.getPort());
//                    s.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }).run();
//        }

        // 5 群里有人问的
        Socket s = ss.accept();
//        InputStream is = s.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//        System.out.println(s.getPort() + "--" + s.getInetAddress());
//        String firstLine = br.readLine();
//        byte[] line = firstLine.getBytes();
//        byte[] data = new byte[5];
//
//        for (int i = 0; i < data.length; i++) {
//            data[i] = line[i];
//            System.out.println("***" + line[i]);
//        }

//        String str = new String(data);
//        int size = Integer.parseInt(str);
//        System.out.println("***" + size);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        for (int i = 0; i < 5; i++) {
            System.out.println(dis.readByte());
        }
        dis.close();
        s.close();
    }
}

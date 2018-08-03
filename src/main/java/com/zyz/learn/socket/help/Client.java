package com.zyz.learn.socket.help;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/4
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket s = new Socket("127.0.0.1", 6666);

//        // 1
//        OutputStream os = s.getOutputStream();
//        DataOutputStream dos = new DataOutputStream(os);
////        Thread.sleep(3000);
//        dos.writeUTF("Hello server!");
//        dos.flush();
//        dos.close();
//        s.close();

        // 2
//        DataInputStream dis = new DataInputStream(s.getInputStream());
//        System.out.println(dis.readUTF());
//        dis.close();
//        s.close();

        // 3
//        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//        DataInputStream dis = new DataInputStream(s.getInputStream());
//        dos.writeUTF("hey!");
//        String st;
//        if ((st = dis.readUTF()) != null) {
//            System.out.println(st);
//        }
//        dos.close();
//        dis.close();
//        s.close();

        // 4
//        Thread.sleep(5000);
//        s.close();

        // 5
        OutputStream os = s.getOutputStream();

//        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
        DataOutputStream dos = new DataOutputStream(os);

        byte[] bytes = {-69, -68, 5, 6, 0};
        dos.write(bytes);
        dos.flush();
//        byte[] bytes = {-69, -68, 0, 0, 0};
//        pw.println(bytes);
//        pw.write(Arrays.toString(bytes));

//        pw.flush();
//        pw.close();
        s.close();

    }
}

package com.typeng.demo.socket.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 客户端.
 * 1. 创建客户端 Socket，指定服务器地址和端口
 * 2. 获取输出流，向服务端发送消息
 * 3. 获取输入流，接收服务器端响应
 * 4. 关闭资源
 *
 * @author ty-peng
 * @since:  2019/3/28 16:03
 */
public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 8888);
                PrintWriter pw = new PrintWriter(socket.getOutputStream()); // 将输出流包装成打印流
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // 发送
            pw.write("用户名：admin;密码：123456");
            pw.flush();
            socket.shutdownOutput(); // 关闭输出流
            // 接收
            String info = null;
            while (null != (info = br.readLine())) {
                System.out.println("客户端接收到服务器端响应：" + info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

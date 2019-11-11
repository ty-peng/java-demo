package com.typeng.demo.socket.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端.
 * 基于 TCP 协议的 Socket 通信，实现用户登录
 * 1. 创建一个服务器端 Socket，指定绑定的端口，并监听此端口
 * 2. 调用 accept() 方法开始监听
 * 3. 获取输入流，读取信息
 * 4. 获取输出流，响应客户端请求
 * 5. 关闭资源
 *
 * @author ty-peng
 * @since:  2019/3/28 16:02
 */
public class Server {
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(8888)
        ) {
            int clientCount = 0;
            Socket socket = null;
            System.out.println("***服务器启动，等待客户端连接***");
            // 多线程
            while (true) {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                clientCount++;
                System.out.println("客户端数量：" + clientCount);
                InetAddress ip = socket.getInetAddress();
                System.out.println(ip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

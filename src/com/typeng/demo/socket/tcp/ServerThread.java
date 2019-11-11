package com.typeng.demo.socket.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 服务器端线程处理.
 *
 * @author ty-peng
 * @since:  2019/3/28 16:56
 */
public class ServerThread extends Thread {

    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream())
        ) {
            // 接收
            String info = null;
            while (null != (info = br.readLine())) {
                System.out.println("服务器读取到客户端信息：" + info);
            }
            socket.shutdownInput(); // 关闭输入流
            // 响应
            pw.write("欢迎登录！");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

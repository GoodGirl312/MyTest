package com.networkProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer  extends Thread{
    private ServerSocket serverSocket;
    public GreetingServer(int port ) throws IOException{
        serverSocket=new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }
    @Override
    public void run(){
        while(true){

            try {
                System.out.println("等待远程连接，端口号为："+serverSocket.getLocalPort()+"...");
                Socket server=serverSocket.accept();
                System.out.println("远程主机地址："+server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());

                DataOutputStream out =new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我："+server.getLocalSocketAddress()+"\nGoodBye!");
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port=80;
        try{
            Thread t=new GreetingServer(port);
            t.run();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

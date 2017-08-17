package com.company.chat.Server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by bezi on 2017.08.15..
 */
public class Client implements Runnable {
    private Socket socket;
    private static int num = 0;

    public Client(Socket s) {
        this.socket = s;
        num += 1;
    }

    @Override
    public void run() {
        try {
            //GET THE SOCKETS INPUT STREAM (THE STREAM THAT YOU WILL GET WHAT THEY TYPE FROM)
            Scanner in = new Scanner(socket.getInputStream());
            //GET THE SOCKETS OUTPUT STREAM (THE STREAM YOU WILL SEND INFORMATION TO THEM FROM)
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while(true) {
                if(in.hasNext()){
                    String input = in.nextLine();
                    System.out.println(num + " said: " + input);
                    out.println("You Said: " + input);
                    out.flush();
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

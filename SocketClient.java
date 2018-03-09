package com.example.rahul.lbs;


import android.content.Intent;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static android.support.v4.app.ActivityCompat.startActivity;

public class SocketClient implements Runnable {

    public int port;
    public String serverAddr;
    public Socket socket;

    public ObjectInputStream In;
    public ObjectOutputStream Out;
    public static ArrayList procLIST = new ArrayList();

    public SocketClient(String SIP, int S_Port) throws IOException {
        try {
            this.serverAddr = SIP;
            this.port = S_Port;
            socket = new Socket(InetAddress.getByName(serverAddr), port);
            Out = new ObjectOutputStream(socket.getOutputStream());
            Out.flush();
            In = new ObjectInputStream(socket.getInputStream());
        } catch (Exception ex) {

        }
    }

    @Override
    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            try {
                Message msg = (Message) In.readObject();
                System.out.println("Incoming : " + msg.toString());

                if (msg.type.equals("Cluster")) {
                    //   LocationTracker lt=new LocationTracker();
                    //  lt.setLati(MainFormActivity.CurrLat);
                    //   lt.setLog(MainFormActivity.CurrLongi);
                    System.out.println("done");
                } else if (msg.type.equals("login")) {
                    if (msg.content.equals("TRUE")) {

                        System.out.println("[SERVER > Me] : Login Successful\n");
                    } else {
                        System.out.println("[SERVER > Me] : Login Failed\n");
                    }
                } else if (msg.type.equals("test")) {
                    System.out.println("Testing Susscesfully");

                } else if (msg.type.equals("PROC")) {
                    System.out.println(msg.content.toString());

                    String msgc = msg.content.toString();
                    msgc = msgc.substring(1, msgc.length() - 1);
                    StringTokenizer st = new StringTokenizer(msgc, ",");
                    while (st.hasMoreTokens()) {
                        procLIST.add(st.nextToken());

                    }

                } else {
                    System.out.println("[SERVER > Me] : Unknown message type\n");
                }
            } catch (Exception ex) {
                keepRunning = false;
                System.out.println("[Application > Me] : Connection Failure\n");

                System.out.println("Exception SocketClient run()");
                ex.printStackTrace();
            }
        }
    }

    public void send(Message msg) {
        try {
            Out.writeObject(msg);
            Out.flush();
            System.out.println("Outgoing : " + msg.toString());

        } catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }

    public void closeThread(Thread t) {
        t = null;
    }


}

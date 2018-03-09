package com.example.rahul.lbs;

import android.app.AlertDialog;



import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartClient {


    public static SocketClient client;
    public static int port;
    public static String serverAddr, username, password;
    public static Thread clientThread;
    public static  boolean serverconnection=false;

    public StartClient() {
        try {
            //serverAddr = "192.168.0.4";
            port = 13001;
            if (!serverconnection) {

                if (serverAddr.length() > 0 && port > 0) {
                    try {
                        client = new SocketClient(serverAddr, port);
                        clientThread = new Thread(client);
                        clientThread.start();
                        client.send(new Message("test", "testUser", "testContent", "SERVER"));
                        serverconnection = true;
                    } catch (Exception ex) {
                        String jj = ex.toString();
                    }
                }
             }



            }catch( Exception ex){
                Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    public static void ConnectTOServer(String ServerIP, String ConnectingPort) {
        serverAddr = ServerIP;
        port = Integer.parseInt(ConnectingPort);

        if (!serverconnection) {

            if (serverAddr.length() > 0 && port > 0) {
                try {
                    client = new SocketClient(serverAddr, port);
                    clientThread = new Thread(client);
                    clientThread.start();
                    client.send(new Message("test", "testUser", "testContent", "SERVER"));
                    serverconnection = true;
                } catch (Exception ex) {
                    String jj = ex.toString();
                }
            }
        }
    }

    public static void login(String UName, String UPWD) {
        username = UName;
        password = UPWD;

        if (username.length() > 0 && password.length() > 0) {
            client.send(new Message("login", username, password, "SERVER"));
        }
    }

    public static void SendMSG(String MSG) {
        String msg = MSG;


        if (msg.length() > 0) {
            client.send(new Message("Cluster", username, msg, username));
        }
    }

    public static void SendMSG(Object MSG) {
        Object msg = MSG;


        if (!msg.toString().equals("")) {
            username="Admin";
            client.send(new Message("Cluster", username, msg, username));
        }
    }

    public static void ConnectTOServer() {


            try {


        } catch (Exception ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

       try {
       //serverAddr = "192.168.0.4";
           port =13001;
            if(!serverconnection){
                if(serverAddr.length()>0 && port>0){
                    try{
                        client = new SocketClient( serverAddr,port);
                        clientThread = new Thread(client);
                        clientThread.start();
                        client.send(new Message("test", "testUser", "testContent", "SERVER"));
                        serverconnection=true;
                    }
                    catch(Exception ex){
                        //      jTextArea1.append("[Application > Me] : Server not found\n");
                    }
                }
            }


           //         Thread.sleep(1000);
           //       login("Admin", "Admin");
           //           Thread.sleep(1000);
           //       SendMSG("SHUTDOWN");
//              Thread.sleep(10000);
//             SendMSG("KILL");
//              Thread.sleep(1000);
//             SendMSG("PROC");
//              Thread.sleep(1000);
//             SendMSG("HIBERNET");
//              Thread.sleep(1000);
//             SendMSG("SLEEP");
//              Thread.sleep(1000);
//             SendMSG("LOGOFF");
//
//
//              Thread.sleep(1000);
//             SendMSG("OPENFILE");
//              Thread.sleep(1000);
//             SendMSG("STARTProcesses");
//

           //  LocationTracker tt=new LocationTracker();
           //  tt.setLog(MainFormActivity.CurrLongi);
           //  System.out.println(MainFormActivity.CurrLongi);
           //   tt.setLati(MainFormActivity.CurrLat);
           //   System.out.println(MainFormActivity.CurrLat);
           //  if(!tt.equals("")) {
           //      SendMSG(tt);
           //  }


        } catch (Exception ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }

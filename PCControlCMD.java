package com.example.rahul.lbs;

import com.example.rahul.lbs.Message;
import com.example.rahul.lbs.SocketClient;
import com.example.rahul.lbs.StartClient;

import android.content.Context;
import android.widget.Toast;


public class PCControlCMD {
	public void CMD_RESTART(Context c)
	{
		try {
			 //       login("Admin", "Admin");
			 //           Thread.sleep(1000);
			    //       SendMSG("SHUTDOWN");
//			              Thread.sleep(10000);
//			             SendMSG("KILL");

			StartClient. client.send(new Message("RESTART", "testUser", "RESTART", "SERVER"));
			 
			Toast.makeText(c, "RESTART", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
	}
	
	public void CMD_SHUTDOWN(Context c)
	{
		StartClient. client.send(new Message("SHUTDOWN", "testUser", "SHUTDOWN", "SERVER"));
		Toast.makeText(c, "SHUTDOWN", Toast.LENGTH_SHORT).show();
	}
	public void CMD_HIBERNATE(Context c)
	{	StartClient. client.send(new Message("HIBERNET", "testUser", "HIBERNET", "SERVER"));
		Toast.makeText(c, "HIBERNET", Toast.LENGTH_SHORT).show();
	}
	public void CMD_SLEEP(Context c)
	{	StartClient. client.send(new Message("SLEEP", "testUser", "SLEEP", "SERVER"));
		Toast.makeText(c, "SLEEP", Toast.LENGTH_SHORT).show();
	}

	public void CMD_OPENFILE(Context c,String fileWithPath)
	{	StartClient. client.send(new Message("OPENFILE", "testUser", fileWithPath, "SERVER"));
		Toast.makeText(c, "OPENFILE", Toast.LENGTH_SHORT).show();
	}
	public void CMD_LOGOFF(Context c)
	{	StartClient. client.send(new Message("LOGOFF", "testUser", "LOGOFF", "SERVER"));
		Toast.makeText(c, "LOGOFF", Toast.LENGTH_SHORT).show();
	}

	public void CMD_STARTProcesses(Context c,String Proc_name)
	{	StartClient. client.send(new Message("STARTProcesses", "testUser", Proc_name, "SERVER"));
		Toast.makeText(c, "STARTProcesses", Toast.LENGTH_SHORT).show();
	}
	public void CMD_KILLProcesses(Context c,String Proc_name)
	{	StartClient. client.send(new Message("KILL", "testUser", Proc_name, "SERVER"));
		Toast.makeText(c, "KILL", Toast.LENGTH_SHORT).show();
	}
	public void CMD_PROC(Context c)
	{	StartClient. client.send(new Message("PROC", "testUser", "PROC", "SERVER"));
		Toast.makeText(c, "PROC", Toast.LENGTH_SHORT).show();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


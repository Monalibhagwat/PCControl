package com.example.rahul.lbs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class loginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final  EditText username=(EditText)findViewById(R.id.IPaddr);
       // final EditText password=(EditText)findViewById(R.id.password);
        //final EditText serverip=(EditText)findViewById(R.id.serverip);

        Button btnlogin=(Button)findViewById(R.id.btnLogin);
        final AlertDialog.Builder alertBulider=new AlertDialog.Builder(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String IpAddr=username.getText().toString();

                StartClient.serverAddr=IpAddr;
               if(IpAddr.length()>0)
                {  try {

                     // StartClient.ConnectTOServer("192.168.0.4","13001");
                    StartClient.main(new String['e']);
                    Thread.sleep(1000);

                    if(StartClient.serverconnection){
                        alertBulider.setMessage("Connected to server:");
                        AlertDialog al=alertBulider.create();
                        al.show();
                        showRemoteframe();
                    }else{
                        alertBulider.setMessage(" Not Connected to server");
                        AlertDialog al=alertBulider.create();
                        al.show();
                    }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    alertBulider.setMessage(" Not Connected to server");
                    AlertDialog al=alertBulider.create();
                    al.show();
                }

            }
        });

    }

  public  void showRemoteframe()
    {
        Intent i =new Intent();
        i.setClass(this, RemoteCMD.class);
        startActivity(i);
    }
    public Handler statushandler =new Handler() {
        @Override
        public void handleMessage(Message msg) {


        }

    };


   
}

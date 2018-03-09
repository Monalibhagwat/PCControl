package com.example.rahul.lbs;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class processlist_Activity extends Activity {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processlist_);
        lv = (ListView) findViewById(R.id.proc_list);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String[] Cmd = new String[SocketClient.procLIST.size()];
        for (int i=0;i<Cmd.length;i++)
        {
            Cmd[i]=SocketClient.procLIST.get(i).toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Cmd);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                try {
                    int itemPosition = position;
                          // ListView Clicked item value
                    String itemValue = (String) lv.getItemAtPosition(position);
                    RemoteCMD.objPcControlCMD.CMD_KILLProcesses(getApplicationContext(),itemValue);


                    // Show Alert
                    Toast.makeText(getApplicationContext(),
                            "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                            .show();
                } catch (Exception e) {
                    System.out.println(e);
                }


            }

        });
    }
}

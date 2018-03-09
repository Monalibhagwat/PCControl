package com.example.rahul.lbs;

import com.example.rahul.lbs.StartClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class RemoteCMD extends Activity {
    ListView lv;
    public static PCControlCMD objPcControlCMD = new PCControlCMD();
    private String m_Text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_cmd);

        lv = (ListView) findViewById(R.id.listView1);
        String[] Cmd = {"RESTART", "SHUTDOWN", "HIBERNATE", "SLEEP", "PROC", "OPENFILE", "LOGOFF", "STARTProcesses"};//KILL
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Cmd);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                try {
                    int itemPosition = position;
                    switch (itemPosition) {
                        case 0:
                            objPcControlCMD.CMD_RESTART(getApplicationContext());
                            break;
                        case 1:
                            objPcControlCMD.CMD_SHUTDOWN(getApplicationContext());
                            break;
                        case 2:
                            objPcControlCMD.CMD_HIBERNATE(getApplicationContext());
                            break;
                        case 3:
                            objPcControlCMD.CMD_SLEEP(getApplicationContext());
                            break;
                        case 4:
                            objPcControlCMD.CMD_PROC(getApplicationContext());

                            show_ProcListActivity();
                            break;
                        case 5:
                            CallInputBox();

                            break;
                        case 6:
                            objPcControlCMD.CMD_LOGOFF(getApplicationContext());
                            break;
                        case 7:
                            CallInputBoxForP();

                            break;

                    }


                    // ListView Clicked item value
                    String itemValue = (String) lv.getItemAtPosition(position);

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


    public void CallInputBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT );
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();

                objPcControlCMD.CMD_OPENFILE(getApplicationContext(), m_Text);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void CallInputBoxForP() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT );
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();

                objPcControlCMD.CMD_STARTProcesses(getApplicationContext(), m_Text);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void show_ProcListActivity() {
        Intent i = new Intent(RemoteCMD.this, processlist_Activity.class);
        startActivity(i);
    }
}

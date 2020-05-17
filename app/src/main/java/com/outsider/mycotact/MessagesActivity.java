package com.outsider.mycotact;

import Models.Messages;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.outsider.mycotact.Adapters.DBAdapter;
import com.outsider.mycotact.Adapters.MessageAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MessagesActivity extends AppCompatActivity {

    ListView mylistview;
    FloatingActionButton fab;
    ArrayList<Messages> mymsgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        mylistview = findViewById(R.id.msgsListview);
        fab = findViewById(R.id.fabid);

        // DATE
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String formattedDate = df.format(c);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessagesActivity.this, AddMsgActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        // SQLITE
        DBAdapter db = new DBAdapter(this);

        mymsgs = new ArrayList<>();
        mymsgs = db.getAllMsgs();

        MessageAdapter msgadapter = new MessageAdapter(this, R.layout.message_item, mymsgs);
        mylistview.setAdapter(msgadapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        mylistview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

                new AlertDialog.Builder(MessagesActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("Are you sure to delete this msg!")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // TODO DELETE MSG

                                // DELETE FROM DATABASE
                                DBAdapter db = new DBAdapter(MessagesActivity.this);
                                Messages msg = mymsgs.get(position);
                                db.deleteMsg(msg.getId());

                                // DELETE FROM ARRAYLIST (FRONT)
                                mymsgs.remove(position);
                                MessageAdapter msgadapter =
                                        new MessageAdapter(MessagesActivity.this, R.layout.message_item, mymsgs);
                                mylistview.setAdapter(msgadapter);

                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setIcon(R.drawable.ic_delete_forever_black_24dp)
                        .show();

                return false;
            }
        });
    }
}

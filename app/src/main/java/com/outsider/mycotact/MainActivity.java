package com.outsider.mycotact;

import Models.Contacts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.outsider.mycotact.Adapters.ContactsAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mylistv;
    Intent phoneIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylistv = findViewById(R.id.mycontactlv);
        //LISTVIEW :

        // 1 - DATA
        final ArrayList<Contacts> mycontacts = new ArrayList<>();
        mycontacts.add(new Contacts("Ayoub 2", "23456789"));
        mycontacts.add(new Contacts("Mohsen", "25673414"));
        mycontacts.add(new Contacts("Imed", "23456789"));
        mycontacts.add(new Contacts("Narjess", "23313098"));
        mycontacts.add(new Contacts("Bilel", "56432543"));
        mycontacts.add(new Contacts("3omda", "90765345"));

        // 2 - ADAPTER
        ContactsAdapter myadapter = new ContactsAdapter(this,
                // 3 - ITEM
                R.layout.contact_item,
                mycontacts);

        mylistv.setAdapter(myadapter);

        mylistv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                phoneIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +
                        mycontacts.get(position).getPhone()));

                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED){
                    startActivity(phoneIntent);
                }else{
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }

            }
        });
            
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.messages_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.messageitem) {
            // Intent
            Intent intent = new Intent(MainActivity.this, MessagesActivity.class);
            startActivity(intent);
        }
        return true;
    }


}

package com.outsider.mycotact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mylistv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylistv = findViewById(R.id.mycontactlv);
        //LISTVIEW :

        // 1 - DATA
        ArrayList<Contacts> mycontacts = new ArrayList<>();
        mycontacts.add(new Contacts("Ayoub 2", "23456789"));
        mycontacts.add(new Contacts("Mohsen", "25673414"));
        mycontacts.add(new Contacts("Imed", "23456789"));
        mycontacts.add(new Contacts("Narjess", "23313098"));
        mycontacts.add(new Contacts("Bilel", "56432543"));
        mycontacts.add(new Contacts("3omda", "90765345"));

        // 2 - ADAPTER
        ContactsAdapter myadapter = new ContactsAdapter(this,
                // 3- ITEM
                R.layout.contact_item,
                mycontacts);

        mylistv.setAdapter(myadapter);
            
    }

}

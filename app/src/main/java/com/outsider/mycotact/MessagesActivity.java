package com.outsider.mycotact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MessagesActivity extends AppCompatActivity {

    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        mylistview = findViewById(R.id.msgsListview);

        // DATE
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String formattedDate = df.format(c);

        ArrayList<Messages> mymsgs = new ArrayList<>();
            mymsgs.add(new Messages("Ayoub 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, seddfff do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ", formattedDate,R.drawable.me));
            mymsgs.add(new Messages("Ayoub 3", "Bonjour haya winek", formattedDate,R.drawable.me));
            mymsgs.add(new Messages("Ayoub 4", "Bonjour haya winek !!", formattedDate,R.drawable.me));
            mymsgs.add(new Messages("Ayoub 5", "Bonjour haya winek", formattedDate,R.drawable.me));
            mymsgs.add(new Messages("Ayoub 6", "Bonjour haya winek", formattedDate,R.drawable.me));
            mymsgs.add(new Messages("Ooredoo", "Bonjour haya winek", formattedDate,R.drawable.me));

        MessageAdapter msgadapter =
                new MessageAdapter(this, R.layout.message_item, mymsgs);

        mylistview.setAdapter(msgadapter);
    }
}

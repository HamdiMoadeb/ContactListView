package com.outsider.mycotact;

import Models.Messages;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.outsider.mycotact.Adapters.DBAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddMsgActivity extends AppCompatActivity {

    EditText msgEd, date, reciever;
    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_msg);

        msgEd = findViewById(R.id.msgid);
        date = findViewById(R.id.dateid);
        reciever = findViewById(R.id.recieverid);
        btnsend = findViewById(R.id.btnsend);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String formattedDate = df.format(c);

        date.setText(formattedDate);

        date.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                startdialogdate();

                return false;
            }
        });


        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(reciever.getText().toString().equals("")){
                    reciever.setError("Champ obligatoire");

                }else if(date.getText().toString().equals("")){
                    date.setError("Champ obligatoire");

                }else if(msgEd.getText().toString().equals("")){
                    msgEd.setError("Champ obligatoire");

                }else if(!testEmail(msgEd.getText().toString())){
                    msgEd.setError("Email Invalid");

                }else {
                    Messages msg = new Messages();
                    msg.setDate(date.getText().toString());
                    msg.setLastMsg(msgEd.getText().toString());
                    msg.setName(reciever.getText().toString());

                    DBAdapter db = new DBAdapter(AddMsgActivity.this);
                    db.ajouterMsg(msg);

                    finish();

                }

            }
        });





    }

    public boolean testEmail(String email){
        return true;
    }





    public void startdialogdate(){

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}

package com.outsider.mycotact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ContactsAdapter extends ArrayAdapter<Contacts> {

    private Context ctx;
    public ContactsAdapter(Context context, int resource, ArrayList<Contacts> objects) {
        super(context, resource, objects);
        this.ctx = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(ctx).inflate(R.layout.contact_item, parent, false);

        TextView name = convertView.findViewById(R.id.namec);
        TextView phone = convertView.findViewById(R.id.phonec);
        TextView firstl = convertView.findViewById(R.id.firstlettre);

        Contacts conts = getItem(position);
        name.setText(conts.getName());
        phone.setText(conts.getPhone());
        firstl.setText(conts.getName().substring(0,1));

        return convertView;
    }
}

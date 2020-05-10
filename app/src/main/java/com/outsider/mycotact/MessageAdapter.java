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
import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends ArrayAdapter<Messages> {

    private Context mycontext;
    public MessageAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Messages> objects) {
        super(context, resource, objects);
        this.mycontext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(mycontext).inflate(R.layout.message_item, parent, false);

        TextView name = convertView.findViewById(R.id.namemsg);
        TextView lastmsg = convertView.findViewById(R.id.msgtext);
        TextView date = convertView.findViewById(R.id.datemsg);
        CircleImageView circleImageView = convertView.findViewById(R.id.profile_image);

        Messages msg = getItem(position);

        name.setText(msg.getName());
        lastmsg.setText(msg.getLastMsg());
        date.setText(msg.getDate());
        circleImageView.setImageResource(msg.getImage());

        return convertView;
    }
}

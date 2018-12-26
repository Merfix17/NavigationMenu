package com.example.a16day;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsAdapter extends ArrayAdapter <Friends> {

    ArrayList <Friends> list;

    public FriendsAdapter(Context context, ArrayList <Friends> list) {
        super(context, 0, list);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_friends,parent,false);
        }

        CircleImageView imageView = convertView.findViewById(R.id.circleImage);
        TextView textView = convertView.findViewById(R.id.friends_name);

        imageView.setImageResource(list.get(position).getImage());
        textView.setText(list.get(position).getName());

        return convertView;

    }
}

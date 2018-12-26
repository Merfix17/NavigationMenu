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

public class AppsAdapter extends ArrayAdapter <Apps> {

    ArrayList <Apps> list;

    public AppsAdapter(Context context, ArrayList <Apps> list) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_apps,parent,false);
        }

        CircleImageView imageView = convertView.findViewById(R.id.item);
        TextView textView = convertView.findViewById(R.id.item_text);

        imageView.setImageResource(list.get(position).getItem());
        textView.setText(list.get(position).getText());

        return convertView;

    }
}

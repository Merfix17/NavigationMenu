package com.example.a16day;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends ArrayAdapter <News> {

    ArrayList <News> list;

    public NewsAdapter(Context context, ArrayList <News> list) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news,parent,false);
        }

        CircleImageView imageView = convertView.findViewById(R.id.circleImage);
        ImageView imageView2 = convertView.findViewById(R.id.post_img);
        TextView textView = convertView.findViewById(R.id.user_name);
        TextView textView2 = convertView.findViewById(R.id.post_text);

        imageView.setImageResource(list.get(position).getIcon());
        imageView2.setImageResource(list.get(position).getImage());
        textView.setText(list.get(position).getUser());
        textView2.setText(list.get(position).getText());

        return convertView;

    }
}

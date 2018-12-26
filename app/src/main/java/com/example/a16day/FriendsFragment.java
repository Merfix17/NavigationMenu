package com.example.a16day;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import com.example.a16day.StoreDatabase;

import static android.support.v4.view.ViewCompat.*;


public class FriendsFragment extends Fragment {

    Button add;
    EditText add_name;
    Dialog myDialog;
    FloatingActionButton fab;
    StoreDatabase storeDb;
    SQLiteDatabase sqdb;

    View view;

    FriendsAdapter adapter;

    ArrayList <Friends> flist = new ArrayList<>();

    public FriendsFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.friends_list, container, false);

        myDialog = new Dialog(getActivity());
        myDialog.setContentView(R.layout.add_friend);

        add_name = myDialog.findViewById(R.id.add_name);
        add = myDialog.findViewById(R.id.add);

        FloatingActionButton fab = view.findViewById(R.id.fab);

        storeDb = new StoreDatabase(getActivity());
        sqdb = storeDb.getWritableDatabase();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        flist.add(new Friends(R.drawable.what, add_name.getText().toString()));
                        adapter.notifyDataSetChanged();
                        addToDatabase();
                        myDialog.dismiss();
                    }
                });

                myDialog.show();

            }
        });


        flist.add(new Friends(R.drawable.hei,"Era"));
        flist.add(new Friends(R.drawable.what,"Joha"));
        flist.add(new Friends(R.drawable.what,"Joha"));
        getData();


        ListView listView = view.findViewById(R.id.listN);
        adapter = new FriendsAdapter(getActivity(), flist);

        listView.setAdapter(adapter);
        return view;

    }

    public void addToDatabase(){
        String username = add_name.getText().toString();

        sqdb.execSQL("INSERT INTO users(name) VALUES ('"+username+"')");
    }

    public void getData() {
        String query = "SELECT * FROM users";
        Cursor cursor = sqdb.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));

                flist.add(new Friends(R.drawable.what, name));
                cursor.moveToNext();
            }
        }
        cursor.close();
    }
}

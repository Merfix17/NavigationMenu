package com.example.a16day;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


public class AppsFragment extends Fragment {

    View view;
    AppsAdapter adapter;
    GridView gridView;

    ArrayList <Apps> apps_list = new ArrayList<>();

    public AppsFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.apps_list, container, false);
        gridView = view.findViewById(R.id.layout_list);

        gridView.setNumColumns(3);

        apps_list.add(new Apps(R.drawable.hei,"Files"));
        apps_list.add(new Apps(R.drawable.what,"Camera"));
        apps_list.add(new Apps(R.drawable.what,"Phone"));

        adapter = new AppsAdapter(getActivity(), apps_list);

        gridView.setAdapter(adapter);
        return view;

    }

}

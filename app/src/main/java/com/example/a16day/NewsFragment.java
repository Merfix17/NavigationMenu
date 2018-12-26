package com.example.a16day;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class NewsFragment extends Fragment {
    View view;

    NewsAdapter adapter;

    ArrayList <News> nlist = new ArrayList<>();

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.news_list, container, false);

        nlist.add(new News(R.drawable.hei, "Merfix", getString(R.string.post_text), R.drawable.fall));
        nlist.add(new News(R.drawable.rocket, "Joradot", "yooooooooo", R.drawable.astronaut));

        ListView listView = view.findViewById(R.id.listV);
        adapter = new NewsAdapter(getActivity(), nlist);

        listView.setAdapter(adapter);
        return view;
    }
}

package com.example.olife.complainbox;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Event extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Event");


        ListView listView = getActivity().findViewById(R.id.event_list);

        final ArrayList<NoticeOrEventInformation> eventList = new ArrayList<>();

        eventList.add(new NoticeOrEventInformation("event","event 1","Description1","time 1"));
        eventList.add(new NoticeOrEventInformation("event","event 2","Description 2","time 2"));
        eventList.add(new NoticeOrEventInformation("event","event 3 Notice 3 Notice 3 Notice 3 Notice 3 Notice 3","Description 3","time 3"));
        eventList.add(new NoticeOrEventInformation("event","event 4","Description 4","time 4"));
        eventList.add(new NoticeOrEventInformation("event","event 5","Description 5 Description 5 Description 5 Description 5 ","time 5 "));


        NoticeEventCustomAdapter adapter = new NoticeEventCustomAdapter(getActivity(),eventList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),eventList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}

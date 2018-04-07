package com.example.olife.complainbox;

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


public class Notice extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notice, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Notice");

        ListView listView = getActivity().findViewById(R.id.nolice_list);

        final ArrayList<NoticeOrEventInformation> noticeList = new ArrayList<>();

        noticeList.add(new NoticeOrEventInformation("notice","Notice 1","Description1","time 1"));
        noticeList.add(new NoticeOrEventInformation("notice","Notice 2","Description 2","time 2"));
        noticeList.add(new NoticeOrEventInformation("notice","Notice 3 Notice 3 Notice 3 Notice 3 Notice 3 Notice 3","Description 3","time 3"));
        noticeList.add(new NoticeOrEventInformation("notice","Notice 4","Description 4","time 4"));
        noticeList.add(new NoticeOrEventInformation("notice","Notice 5","Description 5 Description 5 Description 5 Description 5 ","time 5 "));


        NoticeEventCustomAdapter adapter = new NoticeEventCustomAdapter(getActivity(),noticeList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),noticeList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }


}

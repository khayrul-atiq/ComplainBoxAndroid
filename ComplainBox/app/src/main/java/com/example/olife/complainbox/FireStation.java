package com.example.olife.complainbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FireStation extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        this.setTitle("Police Station");
        listView = findViewById(R.id.list);


        ArrayList<Information> pi = new ArrayList<>();

        pi.add(new PoliceStationInformation("Sahabug fire","Sahabug,Dhaka bangladesh"));
        pi.add(new PoliceStationInformation("Romna fire","Romna,Dhaka bangladesh"));
        pi.add(new PoliceStationInformation("Mirpur 12 fire","Mirpur 12, Dhaka bangladesh"));
        pi.add(new PoliceStationInformation("Motijil fire","Motijil,Dhaka bangladesh"));
        pi.add(new PoliceStationInformation("Jattarabari fire","Jattarabari,Dhaka bangladesh"));
        pi.add(new PoliceStationInformation("Guilistan fire","Gulistan,Dhaka Bangladesh"));

        CustomeAdapter adapter = new CustomeAdapter(this,pi);

        listView.setAdapter(adapter);
    }
}

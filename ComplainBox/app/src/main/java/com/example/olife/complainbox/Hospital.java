package com.example.olife.complainbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Hospital extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        this.setTitle("Hospital List");
        listView = findViewById(R.id.list);

        ArrayList<Information> hi = new ArrayList<>();

        hi.add(new HospitalInformaion("Dhaka Medicale College","Dhaka bangladesh"));
        hi.add(new HospitalInformaion("Bogura Medicale College","Bogura bangladesh"));
        hi.add(new HospitalInformaion("kumilla Medicale College","kumilla bangladesh"));
        hi.add(new HospitalInformaion("chuttogram Medicale College","chuttogram bangladesh"));
        hi.add(new HospitalInformaion("jashore Medicale College","jashore bangladesh"));
        hi.add(new HospitalInformaion("Barishal Medicale College","Barishal bangladesh"));


        CustomeAdapter adapter = new CustomeAdapter(this,hi);

        listView.setAdapter(adapter);
    }
}

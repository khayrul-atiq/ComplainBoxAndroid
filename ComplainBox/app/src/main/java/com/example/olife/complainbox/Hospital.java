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

        ArrayList<InstituteInformation> hi = new ArrayList<>();

        hi.add(new InstituteInformation("Dhaka Medicale College","Dhaka bangladesh"));
        hi.add(new InstituteInformation("Bogura Medicale College","Bogura bangladesh"));
        hi.add(new InstituteInformation("kumilla Medicale College","kumilla bangladesh"));
        hi.add(new InstituteInformation("chuttogram Medicale College","chuttogram bangladesh"));
        hi.add(new InstituteInformation("jashore Medicale College","jashore bangladesh"));
        hi.add(new InstituteInformation("Barishal Medicale College","Barishal bangladesh"));


        InstituteCustomeAdapter adapter = new InstituteCustomeAdapter(this,hi);

        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }
}

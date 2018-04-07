package com.example.olife.complainbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import at.markushi.ui.CircleButton;

/**
 * Created by olife on 4/5/2018.
 */

public class InstituteCustomeAdapter extends ArrayAdapter<InstituteInformation> {


    private final Context context;
    private ArrayList<InstituteInformation> values = new ArrayList<>();

    public InstituteCustomeAdapter(Context context, ArrayList<InstituteInformation> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_institute_row, null);
        }
        //View rowView = inflater.inflate(R.layout.layout_institute_row, parent, false);
        TextView textView1 = (TextView) convertView.findViewById(R.id.institute_name);
        TextView textView2 = (TextView) convertView.findViewById(R.id.institute_location);

        textView1.setText(values.get(position).getName());
        textView2.setText(values.get(position).getLocation());
        // change the icon for Windows and iPhone


        CircleButton phone = convertView.findViewById(R.id.phone);
        CircleButton location = convertView.findViewById(R.id.location);


        phone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Toast.makeText(context,"selected phone"+position,Toast.LENGTH_LONG).show();
                // Your code that you want to execute on this button click
                /*Intent myIntent = new Intent(CurrentActivity.this, NextActivity.class);
                CurrentActivity.this.startActivity(myIntent);*/

            }

        });

        location.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Toast.makeText(context,"selected location"+position,Toast.LENGTH_LONG).show();
                // Your code that you want to execute on this button click
                /*Intent myIntent = new Intent(CurrentActivity.this, NextActivity.class);
                CurrentActivity.this.startActivity(myIntent);*/

            }

        });


        return convertView;
    }
}

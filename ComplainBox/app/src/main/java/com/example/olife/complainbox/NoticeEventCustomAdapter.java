package com.example.olife.complainbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olife on 4/6/2018.
 */

public class NoticeEventCustomAdapter extends ArrayAdapter<NoticeOrEventInformation>{



    private final Context context;
    private ArrayList<NoticeOrEventInformation> values = new ArrayList<>();

    public NoticeEventCustomAdapter(Context context, ArrayList<NoticeOrEventInformation> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_notice_event_row, null);
        }

        TextView title = convertView.findViewById(R.id.title);
        TextView description = convertView.findViewById(R.id.description);
        TextView time = convertView.findViewById(R.id.time);
        ImageView imageView = convertView.findViewById(R.id.notice_event_row_image);

        imageView.setImageResource(values.get(position).getIconImage());
        title.setText(values.get(position).getTitle());
        description.setText(values.get(position).getDescription());
        time.setText(values.get(position).getTime());





        return convertView;
    }
}

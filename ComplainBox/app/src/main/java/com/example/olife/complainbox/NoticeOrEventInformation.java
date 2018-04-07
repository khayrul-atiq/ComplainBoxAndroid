package com.example.olife.complainbox;

/**
 * Created by olife on 4/6/2018.
 */

public class NoticeOrEventInformation {


    private String title;
    private String description;
    private String time;
    private String type;

    private int icon_image = R.drawable.ic_assignment_black_24dp;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }


    public NoticeOrEventInformation(String type,String title, String description, String time) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.type =type;
        if(type.equals("event")) this.icon_image = R.drawable.ic_event_note_black_24dp;
    }

    public int getIconImage() {
        return icon_image;
    }


}

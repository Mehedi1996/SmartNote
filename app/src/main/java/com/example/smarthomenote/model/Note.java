package com.example.smarthomenote.model;

public class Note {

    private String title;
    private String description;
    private int  priority;

    public  Note(){
        //for Firebase
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

}

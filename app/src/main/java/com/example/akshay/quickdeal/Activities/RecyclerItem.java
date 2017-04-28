package com.example.akshay.quickdeal.Activities;

/**
 * Created by Akshay on 20/04/2017.
 */

public class RecyclerItem {
    public String title;
    public String description;

    public RecyclerItem(String title, String description){
        this.title=title;
        this.description=description;

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

}

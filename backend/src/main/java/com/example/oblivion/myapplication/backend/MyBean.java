package com.example.oblivion.myapplication.backend;

import com.jokepack.jokes.JokeWizard;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean
{

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }


}
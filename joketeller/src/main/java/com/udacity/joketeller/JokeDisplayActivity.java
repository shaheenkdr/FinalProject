package com.udacity.joketeller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class JokeDisplayActivity extends AppCompatActivity
{
    public static String JOKE_KEY = "Joke key";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        String joke;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                joke= null;
            } else {
                joke= extras.getString("JOKE");
            }
        } else {
            joke = (String) savedInstanceState.getSerializable("JOKE");
        }
        TextView jokex = (TextView) findViewById(R.id.jokeText);
        if(jokex!=null)
            jokex.setText(joke);
    }


}

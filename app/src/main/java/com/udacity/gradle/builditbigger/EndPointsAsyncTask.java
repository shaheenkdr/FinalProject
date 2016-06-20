package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.oblivion.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.joketeller.JokeDisplayActivity;

import java.io.IOException;

public class EndPointsAsyncTask extends AsyncTask<Void, Void, String>
{
    private Context context;
    private TaskListener listener = null;
     EndPointsAsyncTask(Context context) {
        this.context = context.getApplicationContext();
    }
    private static MyApi myApiService = null;

    public interface TaskListener {
        public void onComplete(String jokeString, Exception e);
    }

    public EndPointsAsyncTask setListener(TaskListener listener) {
        this.listener = listener;
        return this;
    }

    @Override
    protected String doInBackground(Void ... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://gradlejokes-20f2c.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        //listener = params[0];

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result)
    {
        Log.w("Foo",""+result);
        if(result!=null) {
            Intent launchIntent = new Intent(context, JokeDisplayActivity.class);
            launchIntent.putExtra("JOKE", result);
            launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(launchIntent);
        }
    }
}
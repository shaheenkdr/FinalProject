package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Connected test to verify AsyncTask is indeed loading jokes
 */
public class ApplicationTest extends ApplicationTestCase<Application>
{
    String jokeText = null;
    Exception error = null;
    CountDownLatch pivot;
    public ApplicationTest()
    {
        super(Application.class);
    }
    public void testAsyncJoke() throws InterruptedException {
        pivot = new CountDownLatch(1);
        EndPointsAsyncTask task = new EndPointsAsyncTask(getSystemContext());
        task.setListener(new EndPointsAsyncTask.TaskListener() {
            @Override
            public void onComplete(String joke, Exception ex) {
                jokeText = joke;
                error = ex;
                pivot.countDown();
            }
        }).execute();
        pivot.await();

        assertNull(error);
        assertFalse(TextUtils.isEmpty(jokeText));
    }
}
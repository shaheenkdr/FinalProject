/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.oblivion.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jokepack.jokes.JokeWizard;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.oblivion.example.com",
                ownerName = "backend.myapplication.oblivion.example.com",
                packagePath = ""
        )
)
public class MyEndpoint
{

    /**
     * A simple endpoint method that tells a joke
     */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke()
    {
        MyBean response = new MyBean();
        JokeWizard joker = new JokeWizard();
        response.setData(joker.returnJoke());
        return response;
    }

}

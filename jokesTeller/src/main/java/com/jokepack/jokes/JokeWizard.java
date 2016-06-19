package com.jokepack.jokes;


import java.util.Random;

public class JokeWizard
{

   private Random random = new Random();

    public String returnJoke(){
        String joke;
        switch (random.nextInt(3)) {
            case 0:
                joke = "Why do Java developers wear glasses? Because they can't C#";
                break;
            case 1:
                joke = "Programming is like sex, One mistake and you have to support it for the rest of your life";
                break;
            default:
                joke = "See the computer.It is dumber than a human but smarter than a programmer";
                break;
        }
        return joke;
    }

}

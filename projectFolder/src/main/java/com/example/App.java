package com.example;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;



public class App 
{
    
    public static void main( String[] args )throws LoginException{
        JDA discbot = JDABuilder.createDefault("MTAxMzUyMDE5NzY0ODM4NDA1Mg.GhhIO3.r9B1YbjaNct-_QnFee367ScUCPnTzS5etq7NUY")
        .setActivity(Activity.playing("MINECRAFT"))
        .addEventListeners(new Commands())
        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
        .build();

        //String[] foodList = {"Beef Noodle Soup", "Oyster Omelet", "Oyster Vermiceilli"};
        
        

    }
}

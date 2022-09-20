package com.example;


import java.util.ArrayList;
import java.util.Collections;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Commands extends ListenerAdapter {
    public ArrayList<String> dish = new ArrayList<>();
    public HashMap<String,String> recipes = new HashMap<>();
    public ArrayList<String> factsList = new ArrayList<>();

    public ArrayList<String> quiz = new ArrayList<>();
    public HashMap<String, String> answerkey = new HashMap<>();
    public boolean isQuizOn = true;


    private void innit(){
        dish.add("Beef Noodle Soup");
        dish.add("Oyster Omelet");
        dish.add("Oyster Vermicelli");
        dish.add("Danzai Noodles");
        dish.add("Stir Fried Mi Fun");
        dish.add("Three Cup Chicken");
        dish.add("Taiwanese Turkey Rice");
        dish.add("Braised Pork Rice");
        dish.add("Scallion Pancake Beef Wraps");
        dish.add("Taiwanese Popcorn Chicken");
        recipes.put(dish.get(0),"\nhttps://cooking.nytimes.com/recipes/1021705-taiwanese-beef-noodle-soup");
        recipes.put(dish.get(1),"\nhttps://www.sugarlaws.com/recipe.php?id=8627");
        recipes.put(dish.get(2),"\nhttps://www.angelwongskitchen.com/taiwaneseoysternoodles.html");
        recipes.put(dish.get(3),"\nhttps://www.sugarlaws.com/recipe.php?id=8961");
        recipes.put(dish.get(4),"\nhttps://www.phasechangeskitchen.com/blog/mifen");
        recipes.put(dish.get(5),"\nhttps://rasamalaysia.com/three-cups-chicken-recipe/");
        recipes.put(dish.get(6),"\nhttps://www.epicurious.com/recipes/food/views/taiwanese-turkey-rice-clarissa-wei");
        recipes.put(dish.get(7),"\nhttps://www.vice.com/en/article/k7wqgm/lu-rou-fan-recipe");
        recipes.put(dish.get(8),"\nhttps://www.hotchefs.co/recipes/chef-eric-sze-scallion-pancake-beef-wraps-recipe");
        recipes.put(dish.get(9),"\nhttps://youtu.be/k7t3e-XP5xA");
    }
    
    private void quiz(){
        quiz.add("What is the tallest building in Taiwan?");
        quiz.add("What language do Taiwanese people speak?");
        quiz.add("Is Beef Noodle Soup from Taiwan?");
        quiz.add("If the population of Taiwan was just 100 people, how many would be Taiwanese?");
        quiz.add("What are indigenous people called in Taiwan?");
        quiz.add("What number is consider unlucky in Taiwan?");
        quiz.add("What color symbolizes good luck?");
        quiz.add("What color symbolizes death?");
        quiz.add("What is the common drug wrap in leaves?");
        quiz.add("What natural disaster caused 921 incident?");
        answerkey.put(quiz.get(0), "/Taipei-101");
        answerkey.put(quiz.get(1), "/Taiwanese");
        answerkey.put(quiz.get(2), "/Yes");
        answerkey.put(quiz.get(3), "/84");
        answerkey.put(quiz.get(4), "/Formosan");
        answerkey.put(quiz.get(5), "/4");
        answerkey.put(quiz.get(6), "/Red");
        answerkey.put(quiz.get(7), "/White");
        answerkey.put(quiz.get(8), "/Betel-Nut");
        answerkey.put(quiz.get(9), "/Earthquakes");

    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        //for hungry
        if(dish.size() == 0){
            innit();
        }
        //for !history
        try{
            File funfact = new File("/Users/vincentlee/Downloads/taiwanbot.txt");
            
            //BufferedReader br = new BufferedReader(new FileReader(funfact));
            Scanner sc = new Scanner(funfact);
            String str;
            while(sc.hasNextLine()){
                str = sc.nextLine();
                factsList.add(str);
                
            }

            Collections.shuffle(factsList);
            sc.close();

        }catch(FileNotFoundException e){
            event.getChannel()
            .sendMessage("The history textfile could not be found")
            .queue();
        }catch(Exception e){

    }
        //for !funfact
        if(quiz.size() == 0){
            quiz();
        }
        
        String[] args = event.getMessage().getContentRaw().split(" ");
        
        //am I able to use a switch statement
        Collections.shuffle(dish);
        if(args[0].equals("!help")){
            try{
            String menuStr = "";
            File helpmenu = new File("/Users/vincentlee/helpmenu.txt");
            Scanner scan = new Scanner(helpmenu);
            while(scan.hasNextLine()){
                menuStr+= "\n" + scan.nextLine();
            }
            event.getChannel()
                .sendMessage(menuStr)
                .queue();
            scan.close();


        }catch(Exception e){

    }
           
        }
        if(args[0].equals("!hungry")){
            isQuizOn = false;
            event.getChannel()
            .sendMessage(dish.get(0) + ": " + recipes.get(dish.get(0)))
            .queue();
        }
        if(args[0].equals("!funfact")){
            isQuizOn = false;
            event.getChannel()
            .sendMessage(factsList.get(0))
            .queue();
        }
        if(args[0].equals("!quiz")){
            isQuizOn = true;
            Collections.shuffle(quiz);
            event.getChannel()
            .sendMessage(quiz.get(0))
            .queue();
            
        }
        //problem: stuck on old message cant get new message
        if(isQuizOn && (args[0].equals(answerkey.get(quiz.get(0))))){ 
            event.getChannel()
            .sendMessage("That's right!")
            .queue();
            isQuizOn = false;
            
        }
        else if(isQuizOn && (args[0].charAt(0) == '/') && !(args[0].equals("!quiz")) && !(args[0].equals("!quit"))){
            event.getChannel()
            .sendMessage("try again!")
            .queue();
        }
        else if(isQuizOn && (args[0].equals("!quit"))){
            isQuizOn = false;
            event.getChannel()
            .sendMessage("Thank you for playing!")
            .queue();
        }
        
        //taiwanese songs
        //taiwanese bot
        //fact 
        //spot taiwan 101
        //history quiz
        //spam



    }
    
}

# CultureBotTW
Hello!
Welcome to the CultureBotTw repo, a Discord Bot that allows you explore the different aspects of Taiwanese Culture through a fun, engaging discord bot you can add to your server.
You can learn about new Taiwanese foods, fun facts about Taiwan, and particpate in a in-bot quiz to test your newly learned knowledge!

# To get started:

git clone the repo

make sure you change the pathfile of the txt files from the textFilesDependencies folder in Commands.java in line 80 and 113 

should be the file path from your own laptop!

File funfact = new File("/Users/vincentlee/CultureBotTW/textFileDependencies/funFacts.txt");


File helpmenu = new File("/Users/vincentlee/CultureBotTW/textFileDependencies/helpMenu.txt");


In line 16 of App.java, make sure you create your own discord bot token in order to host the bot,
JDA discbot = JDABuilder.createDefault("MTAxMzUyMDE5NzY0ODM4NDA1Mg.GhhIO3.r9B1YbjaNct-_QnFee367ScUCPnTzS5etq7NUY")
change the token "MTAxMzUyMDE5NzY0ODM4NDA1Mg.GhhIO3.r9B1YbjaNct-_QnFee367ScUCPnTzS5etq7NUY" to your own Discord Bot Token

Make sure to run the bot through the Run command in the IDE instead of compiling and running in the terminal!

# Future for CultureBotTW:

Will add more features in the future such as suggesting tourism attractions(includes image processing), playing Taiwanese songs, and a much complex quiz.

package project.anemonebot.anemone;


import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.anemonebot.anemone.util.TokenReader;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.util.Random;

public class AnemoneBotService {

    @Autowired
    ReadyListener readyListener;

    public int rollDice(int minNumber, int maxNumber){
        Random random = new Random();
        return random.nextInt(maxNumber-minNumber) + minNumber;
    }

    public int rollDice(int maxNumber){
        Random random = new Random();
        return random.nextInt(maxNumber);
    }

    public int rollDice(){
        Random random = new Random();
        return random.nextInt(100);
    }

    public void postGithubResponse(String message) {
        JDA jda = null;
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(new TokenReader().readAnemoneToken())
                    .buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MessageChannel channel = jda.getTextChannels().get(0);
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Github");
        embedBuilder.setColor(Color.red);
        embedBuilder.addField("Information", message, false);
        channel.sendMessage(embedBuilder.build()).queue();
        jda.shutdown();
    }
}

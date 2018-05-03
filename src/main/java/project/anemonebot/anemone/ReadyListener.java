package project.anemonebot.anemone;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;


public class ReadyListener extends ListenerAdapter {

    public static void main(String[] args) {
        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken("NDQwNTM4MzQ4NDg2OTE4MTY0.DcjLNw.tRLEmI2U70JjGNV00YQUT-kaxU8")
                    .addEventListener(new ReadyListener())
                    .buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        JDA jda = event.getJDA();
        long responseNumber = event.getResponseNumber();

        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel messageChannel = event.getChannel();

        String msg = message.getContentDisplay();

        boolean bot = author.isBot();

        if (event.isFromType(ChannelType.TEXT) && !author.isBot() && msg.startsWith("!Hello")) {
            messageChannel.sendMessage("Hello " + author.getName()).queue();
        }

        if (event.isFromType(ChannelType.TEXT) && msg.startsWith("!delete")) {
            String messageID = msg.replaceAll("!delete", "");
            messageChannel.deleteMessageById(messageID).queue();
        }

    }
}



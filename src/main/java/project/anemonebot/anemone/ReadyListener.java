package project.anemonebot.anemone;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import project.anemonebot.anemone.util.TokenReader;

import javax.security.auth.login.LoginException;


public class ReadyListener extends ListenerAdapter {

    TokenReader tokenReader = new TokenReader();


    /**
     * Initializes a connection to Discord and the channel as well as correct settings.
     */
    public void initializeJDA() {
        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(tokenReader.readAnemoneToken())
                    .addEventListener(new ReadyListener())
                    .buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Listener for Discord Channel. Called when someone writes in the channel.
     *
     * Currently holds logic for the bot commands, these will later be moved to a dedicated service.
     * @param event
     */
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


    /**
     * Listener for Discord Channel. Called when someone changes their status.
     * @param event
     */
    @Override
    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {
        JDA jda = event.getJDA();
        User user = event.getEntity();
        TextChannel channel = jda.getTextChannels().get(0);
        OnlineStatus oldOnlineStatus = event.getOldOnlineStatus();
        OnlineStatus newOnlineStatus = event.getNewOnlineStatus();

        if(oldOnlineStatus.getKey().equals("offline") && newOnlineStatus.getKey().equals("online")){
            channel.sendMessage("Welcome back " + user.getName()).queue();
        }
    }


}



package project.anemonebot.anemone;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;
import project.anemonebot.anemone.util.TokenReader;

import javax.security.auth.login.LoginException;

@Component
public class ReadyListener extends ListenerAdapter {

    private TokenReader tokenReader = new TokenReader();
    private AnemoneBotService service = new AnemoneBotService();


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

        else if (event.isFromType(ChannelType.TEXT) && msg.startsWith("!delete")) {
            String messageID = msg.replaceAll("!delete", "");
            messageChannel.deleteMessageById(messageID).queue();
        }

        else if(event.isFromType(ChannelType.TEXT) && msg.startsWith("!RegisterGame")) {
            PrivateChannel privchannel = author.openPrivateChannel().complete();
            privchannel.sendMessage("Wrong command.").queue();
        }

        else if(event.isFromType(ChannelType.TEXT) && msg.toLowerCase().startsWith("!rolldice")){
            String firstValueString = null;
            String lastValueString = null;
            int firstValue;
            int lastValue;

            msg = msg.trim();
            if(msg.length() != 9) {
                try {
                    firstValueString = msg.substring(msg.indexOf(" ") + 1, msg.lastIndexOf((" ")));
                    lastValueString = msg.substring(msg.lastIndexOf(" ") + 1);
                } catch (StringIndexOutOfBoundsException e){
                    e.printStackTrace();
                }

            }

            if(null != firstValueString && null != lastValueString){
                firstValue = Integer.parseInt(firstValueString);
                lastValue = Integer.parseInt(lastValueString);
                messageChannel.sendMessage(author.getName() + " rolled: " + service.rollDice(firstValue, lastValue) + " (" + firstValue + "-" + lastValue + ")").queue();
            }
            else if(null != firstValueString){
                firstValue = Integer.parseInt(firstValueString);
                messageChannel.sendMessage(author.getName() + " rolled: " + service.rollDice(firstValue) + " (0" + "-" + firstValue + ")").queue();
            }
            else{
                messageChannel.sendMessage(author.getName() + " rolled: " + service.rollDice() + " (0-100)").queue();
            }

        }
        else if(event.isFromType(ChannelType.TEXT) && msg.equalsIgnoreCase("!help")){
            StringBuilder helpString = new StringBuilder();
            helpString.append("!Rolldice {x} {y} \nRolls a dice, results are shown in the channel. \nParameter x: Lowest possible value \nParameter y: Highest possible value.\nParameters required: None");
            helpString.append("\n\n!Delete {x} \nDeletes the message with the specified ID. \nParameter x: Message ID. \nParameters required: x");

            messageChannel.sendMessage(helpString).queue();
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

    /**
     *
     * @param event
     */
    @Override
    public void onPrivateMessageReceived (PrivateMessageReceivedEvent event)
    {

    }

    /**
     * Listener for Discord Channel. Called when bot is operational.
     * @param event
     */
    @Override
    public void onReady(ReadyEvent event){
        TextChannel channel = event.getJDA().getTextChannels().get(0);
        channel.sendMessage("Anemone Bot Online.").queue();
    }

}



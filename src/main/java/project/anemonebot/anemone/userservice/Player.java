package project.anemonebot.anemone.userservice;

import net.dv8tion.jda.core.entities.User;

import javax.persistence.*;

@Entity
public class Player {
    private int playerLevel;
    private String playerName;
    @OneToOne
    private PlayerClass playerClass;
    private int playerXP;
    @Id
    private String discriminator;


    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

//    public PlayerClass getPlayerClass() {
//        return playerClass;
//    }
//
//    public void setPlayerClass(PlayerClass playerClass) {
//        this.playerClass = playerClass;
//    }

    public int getPlayerXP() {
        return playerXP;
    }

    public void setPlayerXP(int playerXP) {
        this.playerXP = playerXP;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }
}

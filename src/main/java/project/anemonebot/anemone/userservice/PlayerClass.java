package project.anemonebot.anemone.userservice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlayerClass {

    @Id
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

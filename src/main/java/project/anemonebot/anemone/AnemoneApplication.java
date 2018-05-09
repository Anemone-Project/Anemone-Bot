package project.anemonebot.anemone;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnemoneApplication {

    public static void main(String[] args) {
        ReadyListener readyListener = new ReadyListener();
        readyListener.initializeJDA();
        SpringApplication.run(AnemoneApplication.class, args);
    }
}

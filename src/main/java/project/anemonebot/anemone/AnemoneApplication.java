package project.anemonebot.anemone;



public class AnemoneApplication {

    public static void main(String[] args) {
        ReadyListener readyListener = new ReadyListener();
        readyListener.initializeJDA();
    }
}

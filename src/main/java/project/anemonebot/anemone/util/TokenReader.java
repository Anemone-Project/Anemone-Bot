package project.anemonebot.anemone.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TokenReader {

    FileReader fileReader;
    BufferedReader bufferedReader;

    Logger log = LogManager.getLogger(getClass());

    public String readAnemoneToken(){
        {
            try {
                fileReader = new FileReader("anemone-token.txt");
                bufferedReader = new BufferedReader(fileReader);
                String token = bufferedReader.readLine();
                log.debug("Inside TokenReader with token: " + token);
                return token;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }
}

package project.anemonebot.anemone.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TokenReader {

    FileReader fileReader;
    BufferedReader bufferedReader;

    Logger log = LogManager.getLogger(getClass());


    /**
     * Method for reading token from text file.
     * @return String token.
     */
    public String readAnemoneToken(){
        {
            try {
                fileReader = new FileReader("src/main/resources/anemonetoken.txt");
                bufferedReader = new BufferedReader(fileReader);
                String token = bufferedReader.readLine();
                log.debug("Inside TokenReader with token: " + token);
                bufferedReader.close();
                fileReader.close();
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

package project.anemonebot.anemone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/anemone")
public class AnemoneBotController {

    Logger logger = LogManager.getLogger(getClass());
    AnemoneBotService service = new AnemoneBotService();

    /**
     * Endpoint for testing connection to micro-service.
     * @return new Greeting object.
     */
    @RequestMapping(value = "/anemonetest", method = RequestMethod.GET, produces = "text/plain")
    public String anemoneConnectionTest() {
        return "Connection OK!";
    }

    @RequestMapping(value = "/anemoneintergrationtest/{word}", method = RequestMethod.GET)
    public String anemoneIntergrationTest(@PathVariable ("word") String word){
        return sendToGateway(word);
    }

    /**
     * Endpoint for testing connection between micro-services.
     * @param word Used to gauge whether or not request reached end point.
     * @return
     */
    public String sendToGateway(String word){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:26501/anemone/anemoneintergrationtest/" + word, String.class);

        return responseEntity.getBody();
    }

    @RequestMapping(value = "/receivegithubresponse", method = RequestMethod.POST)
    public void receiveGithubResponse(@RequestBody String message){
        service.postGithubResponse(message);
    }
}

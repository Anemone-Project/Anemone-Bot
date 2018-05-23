package project.anemonebot.anemone.githubservice;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/github")
public class GithubController {

    GithubService service = new GithubService();

    @RequestMapping(value = "/receivegithubresponse", method = RequestMethod.POST)
    public void receiveGithubResponse(@RequestBody String message){
        service.handleGithubRequest(message);
    }
}

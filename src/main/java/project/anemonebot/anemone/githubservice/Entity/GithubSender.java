package project.anemonebot.anemone.githubservice.Entity;

/**
 * Class with data about the initiator of the github change.
 */

public class GithubSender {

    private String login;
    private Long id;
    private String url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

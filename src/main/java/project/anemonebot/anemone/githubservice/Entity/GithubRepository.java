package project.anemonebot.anemone.githubservice.Entity;

/**
 * Class with information about a specific github repository.
 */

public class GithubRepository {

    private Long id;
    private String name;
    private String full_name;
    private GithubUser owner;
    private String html_url;
    private String master_branch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return full_name;
    }

    public void setFullname(String fullname) {
        this.full_name = fullname;
    }

    public GithubUser getOwner() {
        return owner;
    }

    public void setOwner(GithubUser owner) {
        this.owner = owner;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getMaster_branch() {
        return master_branch;
    }

    public void setMaster_branch(String master_branch) {
        this.master_branch = master_branch;
    }
}

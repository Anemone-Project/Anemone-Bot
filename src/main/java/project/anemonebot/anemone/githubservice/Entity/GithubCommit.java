package project.anemonebot.anemone.githubservice.Entity;

import java.util.Set;

/**
 * Class with data for a specific commit on Github.
 */

public class GithubCommit {

    private String id;
    private String tree_id;
    private Boolean distinct;
    private String message;
    private String timestamp;
    private String url;
    private GithubUser author;
    private GithubUser committer;
    private Set<String> modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTree_id() {
        return tree_id;
    }

    public void setTree_id(String tree_id) {
        this.tree_id = tree_id;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GithubUser getAuthor() {
        return author;
    }

    public void setAuthor(GithubUser author) {
        this.author = author;
    }

    public GithubUser getCommitter() {
        return committer;
    }

    public void setCommitter(GithubUser commiter) {
        this.committer = commiter;
    }

    public Set<String> getModified() {
        return modified;
    }

    public void setModified(Set<String> modified) {
        this.modified = modified;
    }

    public StringBuilder getModifiedStrings(){
        StringBuilder stringBuilder = new StringBuilder();
        modified.iterator().forEachRemaining(s -> stringBuilder.append(s).append("\n"));
        return stringBuilder;
    }
}

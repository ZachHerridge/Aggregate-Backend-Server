package com.mhack.aggregate.server.api.post.domain;

public class Post {

    private String userId;
    private String title;
    private String body;
    private long time = System.currentTimeMillis();

    public Post setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public Post setBody(String body) {
        this.body = body;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}

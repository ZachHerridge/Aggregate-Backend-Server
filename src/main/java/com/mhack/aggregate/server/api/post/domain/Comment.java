package com.mhack.aggregate.server.api.post.domain;

public class Comment {

    private String _key;

    private String postId;
    private String userId;
    private String body;
    private long time = System.currentTimeMillis();
    private String displayName;

    public String getKey() {
        return _key;
    }

    public String getPostId() {
        return postId;
    }

    public Comment setPostId(String postId) {
        this.postId = postId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Comment setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Comment setBody(String body) {
        this.body = body;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Comment setTime(long time) {
        this.time = time;
        return this;
    }
}

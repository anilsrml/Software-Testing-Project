package utils;

import models.PostRequest;

public final class TestData {

    public static final String POSTS_ENDPOINT = "/posts";
    public static final long GET_RESPONSE_TIME_LIMIT_MS = 2000L;
    public static final long POST_RESPONSE_TIME_LIMIT_MS = 3000L;

    private TestData() {
    }

    public static PostRequest createValidPostRequest() {
        return new PostRequest("automation test", "rest assured demo", 1);
    }
}

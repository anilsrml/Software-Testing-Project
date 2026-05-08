package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.PostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostTests extends BaseTest {

    @Test
    @DisplayName("POST /posts should create a new post with expected payload and SLA")
    void shouldCreateNewPostWithExpectedResponseValues() {
        PostRequest requestBody = TestData.createValidPostRequest();

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post(TestData.POSTS_ENDPOINT);

        response.then()
                .statusCode(201)
                .body("title", equalTo(requestBody.getTitle()))
                .body("userId", equalTo(requestBody.getUserId()))
                .time(lessThan(TestData.POST_RESPONSE_TIME_LIMIT_MS));
    }
}

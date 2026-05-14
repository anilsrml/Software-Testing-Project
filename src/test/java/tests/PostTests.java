package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.PostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.TestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostTests extends BaseTest {

    @Test
    @Tag("functional")
    @DisplayName("POST /posts should create a new post with expected payload")
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
                .body("userId", equalTo(requestBody.getUserId()));
    }

    @Test
    @Tag("performance")
    @DisplayName("POST /posts should respond within SLA")
    void shouldCreateNewPostWithinSla() {
        PostRequest requestBody = TestData.createValidPostRequest();

        given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post(TestData.POSTS_ENDPOINT)
                .then()
                .statusCode(201)
                .time(lessThan(TestData.POST_RESPONSE_TIME_LIMIT_MS));
    }
}
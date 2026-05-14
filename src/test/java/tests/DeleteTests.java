package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.TestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class DeleteTests extends BaseTest {
    @Test
    @Tag("functional")
    @DisplayName("DELETE /posts/1 should return success response")
    void shouldDeletePostById() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .delete(TestData.POSTS_ENDPOINT + "/1");

        response.then()
                .statusCode(200)
                .body(equalTo("{}"));
    }
    @Test
    @Tag("performance")
    @DisplayName("DELETE /posts/1 should respond within SLA")
    void shouldDeletePostByIdWithinSla() {
        given()
                .spec(requestSpec)
                .when()
                .delete(TestData.POSTS_ENDPOINT + "/1")
                .then()
                .statusCode(200)
                .time(lessThan(TestData.DELETE_RESPONSE_TIME_LIMIT_MS));
    }
}
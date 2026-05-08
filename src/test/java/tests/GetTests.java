package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;

public class GetTests extends BaseTest {

    @Test
    @DisplayName("GET /posts/1 should return expected post details within SLA")
    void shouldReturnPostByIdWithExpectedFieldsAndResponseTime() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get(TestData.POSTS_ENDPOINT + "/1");

        response.then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", not(isEmptyOrNullString()))
                .time(lessThan(TestData.GET_RESPONSE_TIME_LIMIT_MS));
    }
}

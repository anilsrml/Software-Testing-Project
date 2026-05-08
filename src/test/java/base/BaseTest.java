package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    protected static final String BASE_URI = "https://jsonplaceholder.typicode.com";
    protected static RequestSpecification requestSpec;

    @BeforeAll
    static void setupRequestSpecification() {
        RestAssured.baseURI = BASE_URI;
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }
}

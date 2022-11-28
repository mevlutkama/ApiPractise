package get_requests;

import base_urls.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;

public class Get07 extends DummyBaseUrl {
    /*
    When I send a GET request to REST API URL http://dummy.restapiexample.com/api/v1/employees
    And Accept type is “application/JSON”
    Then HTTP Status Code should be 200
    And “Garrett Winters” should be displayed among data     */

    @Test
    public void get07(){
        // Set the Url
        spec.pathParam("first","employees");

        // Set the expected data

        // Send the Request and get the Response
        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();

        // Do Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.employee_name", hasItem("Garrett Winters"));
    }
}

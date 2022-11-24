package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get04 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"
    */
    @Test
    public void get04(){
        // Set the Url
        spec.pathParam("first", "booking").queryParams("firstname","Brandon","lastname", "Wilson");

        // Set the expected data

        // Send the Request and get the Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // Do Assertion
        assertEquals(200, response.statusCode());
        assertTrue(response.asString().contains("bookingid"));
    }
}

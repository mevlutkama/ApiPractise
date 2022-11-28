package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get08 extends HerOkuAppBaseUrl {
    /*
    Given
        "https://restful-booker.herokuapp.com/booking/5 "
    When
      I send a GET request to the Url
   And
       Accept type is "application/json"
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       first name should be "Der"
   And
       And total price should be 11111
   And
       And checkin date should be "2020-11-02"

 */
    @Test
    public void get08(){
        // Set the Url
        spec.pathParams("first", "booking", "second", 5);

        // Set the expected data

        // Send the Request and get the Response
        Response response = given().spec(spec).accept("application/json").when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        response.then().assertThat().
                statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("Nick"),
                        "totalprice", equalTo(100), "bookingdates.checkin", equalTo("2021-11-11"));

    }
}

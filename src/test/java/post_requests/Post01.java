package post_requests;

import base_urls.ReqresInBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends ReqresInBaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "580",
                                                "createdAt": "2022-11-24T13:57:27.953Z"
}
     */
    @Test
    public void post01(){
        // Set the Url
        spec.pathParam("first","users");

        // Set the expected data
        ReqresPojo expectedData = new ReqresPojo("morpheus","leader");
        System.out.println("expectedData = " + expectedData);

        // Send the Request and get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
        response.prettyPrint();

        // Do Assertion
        Map<String,String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(),actualData.get("name"));
        assertEquals(expectedData.getJob(),actualData.get("job"));
    }
}

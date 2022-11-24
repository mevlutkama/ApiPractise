package get_requests;

import base_urls.ReqresInBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get06 extends ReqresInBaseUrl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */
    @Test
    public void get06(){
        // Set the Url
        spec.pathParam("first", "unknown");

        // Set the expected data

        // Send the Request and get the Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        
        // Do Assertion
        assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        List<String> list = jsonPath.getList("data.pantone_value");
        System.out.println("list = " + list);
        List<Integer> greaterThan3 = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("greaterThan3 = " + greaterThan3);
        assertEquals(3,greaterThan3.size());
        List<String> nameIdsGreaterThan3 = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("nameIdsGreaterThan3 = " + nameIdsGreaterThan3);
        assertEquals(2,nameIdsGreaterThan3.size());
    }
}


package day1;

import base_url.Restful;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest extends Restful {

        /*
    Given
            https://restful-booker.herokuapp.com/booking/12
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    //First Step:Set the Url
    //Second Step:Set the Expected Data
    //Third Step:Send the Request and Get the Response
    //Fourt Step.Do Assertion

    @Test
    public void test1(){
        //First Step:Set the Url
        spec.pathParam("first",12);

        //Second Step:Set the Expected Data

        //Third Step:Send the Request and Get the Response
        Response response=given().spec(spec).when().get("/{first}");

        //Fourt Step.Do Assertion
        //1:method:Rest Assert
        response.then().assertThat().statusLine("HTTP/1.1 200 OK").
                                     statusCode(200).
                                     contentType(ContentType.JSON);

        //2.Method:JUnit assert
         assertEquals(200,response.statusCode());
                assertEquals("HTTP/1.1 200 OK",response.statusLine());
                assertEquals("application/json; charset=utf-8", response.contentType());

        //3.Method:Json Path











    }

}

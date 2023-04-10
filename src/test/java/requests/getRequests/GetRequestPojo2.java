package requests.getRequests;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.GoRestDataPojo;
import pojo.GoRestPojo;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetRequestPojo2 extends GoRestBaseUrl {

      /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
            "meta": null,
            "data": {
                "id": 2508,
                "name": "Sharmila Deshpande VM",
                "email": "deshpande_sharmila_vm@becker.name",
                "gender": "female",
                "status": "active"
                 }
          }
    */

    @Test
    public void test01() {

        //First Step:Set the Url
        spec.pathParams("first", "users", "second", 2508);

        //Second Step:Set The Expected Data(Payload)
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508, "Sharmila Deshpande VM", "deshpande_sharmila_vm@becker.name", "female", "active");
        GoRestPojo expectedData = new GoRestPojo(null, goRestDataPojo);
        System.out.println("expectedData = " + expectedData);

        //Third Step:Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        //response.prettyPrint();

        //Fourth Step:Do Assertion
        GoRestPojo actualData = response.as(GoRestPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getMeta(), actualData.getMeta());
        assertEquals(goRestDataPojo.getId(), actualData.getData().getId());
        assertEquals(goRestDataPojo.getName(), actualData.getData().getName());
        assertEquals(goRestDataPojo.getEmail(), actualData.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(), actualData.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(), actualData.getData().getStatus());








    }



}

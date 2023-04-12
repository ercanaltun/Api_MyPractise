package requests.postRequests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {

       /*
    Given
      1) https://jsonplaceholder.typicode.com/todos
      2)
   When
       I send POST Request to the Url
   Then
       Status code is 201 {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
                         }
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/


    @Test
    public void test01() {


        //First Step:Set the Url
        spec.pathParam("first","todos");

        //Second Step:Set The Expected Data(Payload)
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
              Map<String,Object>expectedData=obj.expectedDataMethod(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Fourth Step:Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));





    }


}

package day1;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest4 extends JsonplaceholderBaseUrl {

/*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
   I send a GET request to the Url
 And
     Accept type is "application/json"
 Then
     HTTP Status Code should be 200
 And
     Response format should be "application/json"
 And
     There should be 200 todos
 And
     "quis eius est sint explicabo" should be one of the todos title
 And
     2, 7, and 9 should be among the userIds
 */

    @Test
    public void get01() {

        //1.Set the Url
        spec.pathParam("first", "todos");
        //tek parametre olduğu için pahtParam methodnu kullandık

        //2.Set thr expected data(put,patch,post yapılacak bir işlem yok burda)
        //3.Send the Requset and get the Response
        Response response = given().spec(spec).when().accept(ContentType.JSON)
                .get("/{first}/");
        response.prettyPrint();

        //4.Do Assertion
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", hasSize(200), "title"
                        , hasItem("quis eius est sint explicabo"),
                        "userId", hasItems(2, 7, 9));

    }
}

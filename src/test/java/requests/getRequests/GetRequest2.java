package requests.getRequests;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest2 extends ReqresBaseUrl {

    //https://reqres.in/api/users/5

    /* Matchers ile dataları doğrulayınız
{
    "data": {
        "id": 5,
        "name": "tigerlily",
        "year": 2004,
        "color": "#E2583E",
        "pantone_value": "17-1456"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
    2 */

    @Test
    public void test2(){

       //First Step:  Set the Url
        spec.pathParams("first","user","second",5);

       //Second Step: Set the Expected Data (Payload)

       //Third Step : Send the Request  and Get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

       //Fourt Step:  Do Assertion
        //1.Method:Rest Assert
        response.then().assertThat().body("data.id",equalTo(5),
                "data.name",equalTo("tigerlily"),
                "data.color",equalTo("#E2583E"));


    }

}

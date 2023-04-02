package getRequests;

import base_url.GmiBankBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationGIM.generateToken;

public class GetRequest3 extends GmiBankBaseUrl {

    //http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın
    //   “firstName”: “Melva”,
    //   “lastName”: “Bernhard”,
    //   “email”: “chas.kuhlman@yahoo.com”
    //   “zipCode”: “40207"
    //   “country” “name”: “San Jose”
    //   “login”: “delilah.metz”

    @Test
    public  void test3(){

        spec.pathParams("first","tp-customers","second",11472);

        Response response =given().spec(spec).
                headers("Authorization","Bearer "+generateToken()).
                when().get("/{first}/{second}");
        response.prettyPrint();

        //1.Method: with Rest Assert
        response.then().assertThat().body("type",equalTo("https://www.jhipster.tech/problem/problem-with-message"),
                "status",equalTo(404),"message",equalTo("error.http.404"));

        //2.Method with Json Path
        JsonPath json=response.jsonPath();
       assertEquals("https://www.jhipster.tech/problem/problem-with-message",json.getString("type"));
       assertEquals(404,json.getInt("status"));
       assertEquals("error.http.404",json.getString("message"));

    }




}

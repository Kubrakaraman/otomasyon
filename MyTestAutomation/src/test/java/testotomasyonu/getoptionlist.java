package testotomasyonu;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class getoptionlist extends testotomasyonu {
	public ValidatableResponse getOptionList(String method, String sid)  {

        return given()
                .param("method", method)
                .param("sesionId", sid)
                .when()
                .get("https://m.vodafone.com.tr/tstmaltgateway/api")
                .then();
    }
	
	 public static void main(String[] args) {

	        getoptionlist vodafoneService2 = new getoptionlist();

	        ValidatableResponse response2 = vodafoneService2.getOptionList("getOptionList", "sessionId" );
	        response2.statusCode(200);

	        // response u ekrana yazdýrmaca
	        response2.extract().response().prettyPrint();

	        //response2.body("result.result", equalTo("SUCCESS"));

	        //String sessionId = response.extract().path("session.sessionId");
	        //System.out.println(sessionId);
	      
	    }
	
}

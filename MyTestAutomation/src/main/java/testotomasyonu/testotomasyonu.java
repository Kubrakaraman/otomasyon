package testotomasyonu;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class testotomasyonu {
	

	public  ValidatableResponse createSession(String method, String msisdn, int password) {

        return given()
                .param("method", method)
                .param("msisdn", msisdn)
                .param("password", password)
                .when()
                .get("https://m.vodafone.com.tr/tstmaltgateway/api")
                .then();}
	  
		public ValidatableResponse getAddressList(String method, String sid) {


			return given()
	                .param("method", method)
	                .param("sid",sid)
	                .when()
	                .get("https://m.vodafone.com.tr/tstmaltgateway/api")
	                .then(); }
	
		public  ValidatableResponse createSession2(String method, String msisdn, int password) {

	        return given()
	                .param("method", method)
	                .param("msisdn", msisdn)
	                .param("password", password)
	                .when()
	                .get("https://m.vodafone.com.tr/dce/api")
	                .then();}
		
		  
		public ValidatableResponse getAddressList2(String method, String sid) {

	        return given()
	                .param("method", method)
	                .param("sid",sid)
	                .when()
	                .get("https://m.vodafone.com.tr/dce/api")
	                .then();}

	
	 public  static void main(String[] args) {

	        testotomasyonu vodafoneService = new testotomasyonu();

	        ValidatableResponse response = vodafoneService.createSession("createSession", "5461840016", 11111111);
	        response.statusCode(200);

	        // response u ekrana yazdýrmaca
	        //response.extract().response().prettyPrint();

	        
	        String sessionId = response.extract().path("session.sessionId");
	        //System.out.println(sessionId);
	        
	        
	        //GETADRESSLÝST

	        ValidatableResponse response2 = vodafoneService.getAddressList("getAddressList", sessionId );
	        response2.statusCode(200);
	        response2.extract().response().prettyPrint();
	       

	        // response u ekrana yazdýrmaca
	        //response2.extract().response().prettyPrint();
	        //response2.body("result.result", equalTo("SUCCESS"));
	        //response2.body("result.resultCode", equalTo("S0999000100"));
	        //response2.body("result.resultDesc", equalTo("Ýþleminiz baþarýyla gerçekleþtirilmiþtir."));
	        //response2.body("successful", equalTo("true"));
	        

	        ValidatableResponse response3 = vodafoneService.createSession2("createSession", "5461840016", 11111111);
	        response3.statusCode(200);

	        // response u ekrana yazdýrmaca
	        //response3.extract().response().prettyPrint();

	        //response3.body("result.result", equalTo("SUCCESS"));

	        String sessionId2 = response3.extract().path("session.sessionId");
	        //System.out.println(sessionId);
	        
	        
	        //GETADRESSLÝST2

	        ValidatableResponse response4 = vodafoneService.getAddressList2("getAddressList", sessionId2 );
	        response4.statusCode(200);

	        
	        response4.extract().response().prettyPrint();
	        
	        // response u ekrana yazdýrmaca
	        //response4.body("result.result", equalTo("SUCCESS"));
	        //response4.body("result.resultCode", equalTo("S0999000100"));
	        //response4.body("result.resultDesc", equalTo("Ýþleminiz baþarýyla gerçekleþtirilmiþtir."));
	        //response4.body("successful", equalTo("true"));
	        
	        

	         if ( response2.body("result.result", equalTo("SUCCESS")) != response4.body("result.result", equalTo("SUCCESS"))) {
	        	 
	        	 System.out.println("RESULT FARKLI");
	         }
	         else if (response2.body("result.resultCode", equalTo("0")) != response4.body("result.resultCode", equalTo("0"))) {
	        	 
	        	 System.out.println("RESULTCODE FARKLI");
	        	 
	         }
	         else if (response2.body("result.resultDesc", equalTo("SUCCESS")) != response4.body("result.resultDesc", equalTo("SUCCESS"))) {
	        	 
	        	 System.out.println("RESULTDESC FARKLI");
	        	 
	         }
	         
	         else if (response2.body("successful", equalTo("true")) != response4.body("successful", equalTo("true"))) {
	        	 
	        	 System.out.println("SUCCESSFLAG FARKLI");
	        	 
	         }
	         
	         else 
	         {
	        	 System.out.println("RESULTCODE AYNI");
	         }	         	         
	    }
	 }	


package Assignment.Assignment;
	
	import org.json.JSONObject;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	
	import Assignment.Assignment.APIPropertyReader;
	import Assignment.Assignment.GitPojo;

	public class GitApi {
		
		
		APIPropertyReader apiPropertyReader=new APIPropertyReader();
		GitPojo gitpojo= new GitPojo();
		
		@Test
		
		public void createRepository()
		{		
			RestAssured.baseURI ="https://api.github.com/users/"+apiPropertyReader.getUserName()+"/repos?access_token="+apiPropertyReader.getAuthToken();
			RequestSpecification request = RestAssured.given();

			JSONObject requestParams = new JSONObject();
			requestParams.put("owner", gitpojo.getName()); // Cast
			requestParams.put("description", gitpojo.getDescription());
			requestParams.put("HomePage", gitpojo.getHomepage());
			requestParams.put("private", gitpojo.getPrivate());	
			
			request.body(requestParams.toString());
			Response response = request.get("/register");

			int statusCode = response.getStatusCode();
			System.out.println("The status code recieved: " + statusCode);

			System.out.println("Response body: " + response.body().asString());
		}
	

}

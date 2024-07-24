package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class Products {

    public RequestSpecification httpRequest;
    public Response response;
    public int responseCode;
    public ResponseBody body;

    @Given("Hit the URL of get products api")
    public void hit_the_url_of_get_products_api() {

        RestAssured.baseURI = "https://fakestoreapi.com/";

    }
    @When("The url is passed in the request")
    public void the_url_is_passed_in_the_request() {

        httpRequest = RestAssured.given();
        response = httpRequest.get("/products");

    }
    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {
        responseCode = response.getStatusCode();
        assertEquals(responseCode,200);
    }

    @Then("I verify that the rate of the first product is <FirstProductRate>")
    public void i_verify_that_the_rate_of_the_first_product_is_first_product_rate() {
        body = response.getBody();
        //converting the response into string
        String responseBody = body.asString();
    }

}

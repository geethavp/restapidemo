package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StepDefinition extends Utils {


    public Response respo;
    TestDataBuild data = new TestDataBuild();
    RequestSpecification reqs;
    ResponseSpecification res;
    String associateID;
    APIResources resourceURI;


    @Given("the add associate payload is given with {string} {string}")
    public void the_add_associate_payload_is_given_with(String associateType, String memberIdentifier) throws IOException {

        reqs = given().spec(getRequestSpecification()).body(data.getAddAssociateData(associateType, memberIdentifier));

    }

    @When("for {string} {string} method is used")
    public void for_method_is_used(String resource, String method) {
        // Write code here that turns the phrase above into concrete actions


        // Write code here that turns the phrase above into concrete actions
        res = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        //get the resource URI
//creating object for enum class

        resourceURI = APIResources.valueOf(resource);

        if (method.equalsIgnoreCase("POST")) {
            respo = reqs.when().post(resourceURI.getResource());
        } else if (method.equalsIgnoreCase("GET")) {
            respo = reqs.when().get(resourceURI.getResource());
        }


    }

    @Then("associate is added with status code {int}")
    public void associate_is_added_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

        String responseComplete = respo.asString();
        String location = respo.getHeader("Location").toString();

        getAssociateID(location);

        int actualStatusCode = respo.getStatusCode();
        assertTrue(int1.equals(actualStatusCode));


    }


    @Then("verify {string} using {string}  and {string} method")
    public void verify_using_and_method(String memberIdentifier, String resource, String method) {

        for_method_is_used(resource, method);

        String responseComplete = respo.asString();

        String actual = getJsonPath(responseComplete, memberIdentifier);

        assertEquals(memberIdentifier, actual);

    }


    @Given("the delete associate payload is given")
    public void the_delete_associate_payload_is_given() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reqs = given().spec(getRequestSpecification());
    }

}

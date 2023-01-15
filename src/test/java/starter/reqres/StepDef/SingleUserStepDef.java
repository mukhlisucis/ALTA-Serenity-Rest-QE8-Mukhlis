package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class SingleUserStepDef {
   @Steps
    ReqresAPI reqresAPI ;

    @Given("Get single users id {int}")
    public void getSingleUsersId(int id) {
        reqresAPI.getSingleUsers(id);
    }


    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.SINGLE_USER) ;
    }

    @And("Validate json schema single user")
    public void validateJsonSchemaSingleUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SingleUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema)) ;
    }


    @Given("Get single users id unregistered {int}")
    public void getSingleUsersIdUnregistered(int id) {
        reqresAPI.getSingleUsers(id);
    }

    @Given("Get single users with invalid id {string}")
    public void getSingleUsersWithInvalidId(String id) {
        reqresAPI.getSingleUsersInvalid(id);
    }
}

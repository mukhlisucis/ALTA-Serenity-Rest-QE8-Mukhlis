package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI ;
    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterUser.json");
        reqresAPI.postRegisterUser(json);

    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER) ;
    }


    @And("Validate json schema register user")
    public void validateJsonSchemaRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/RegisterUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema)) ;
    }

    @Given("Post register user with null email value")
    public void postRegisterUserWithNullEmailValue() {
        File json = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterEmailNull.json");
        reqresAPI.postRegisterUser(json);
    }

    @Given("Post register user with null password value")
    public void postRegisterUserWithNullPasswordValue() {
        File json = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterPasswordNull.json");
        reqresAPI.postRegisterUser(json);
    }

    @Given("Post register user with null all variable value")
    public void postRegisterUserWithNullAllVariableValue() {
        File json = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterAllVariableNull.json");
        reqresAPI.postRegisterUser(json);
    }

    @Given("Post register user with wrong variable")
    public void postRegisterUserWithWrongVariable() {
        File json = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterWrongVariable.json");
        reqresAPI.postRegisterUser(json);
    }
}

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

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI ;

    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUser/LoginUser.json");
        reqresAPI.postCreateUser(json);
    }
    @When("send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("validate json schema login user")
    public void validateJsonSchemaLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/LoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema)) ;
    }


    @Given("Post login user with invalid json null email value")
    public void postLoginUserWithInvalidJsonNullEmailValue() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUser/LoginNullEmail.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post login user with invalid json null password value")
    public void postLoginUserWithInvalidJsonNullPasswordValue() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUser/LoginNullPassword.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post login user with invalid json null all variable")
    public void postLoginUserWithInvalidJsonNullAllVariable() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUser/LoginNullVariableValue.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post login user with invalid variable")
    public void postLoginUserWithInvalidVariable() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUser/LoginWrongVariable.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post login user with invalid email")
    public void postLoginUserWithInvalidEmail() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUser/LoginInvalidEmail.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post login user with invalid password")
    public void postLoginUserWithInvalidPassword() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUser/LoginInvalidPassword.json");
        reqresAPI.postCreateUser(json);
    }
}

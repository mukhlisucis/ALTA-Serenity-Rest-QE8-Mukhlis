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

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema)) ;

    }

    @Given("Put update user with invalid json name null value with id {int}")
    public void putUpdateUserWithInvalidJsonNameNullValueWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUserNameNull.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @Given("Put update user with invalid json job null value with id {int}")
    public void putUpdateUserWithInvalidJsonJobNullValueWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUserJobNull.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @Given("Put update user with invalid variable with id {int}")
    public void putUpdateUserWithInvalidVariableWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUserInvalidVariable.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @Given("Put update user with invalid unregistered id with id {int}")
    public void putUpdateUserWithInvalidUnregisteredIdWithId(int id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUserValid.json");
        reqresAPI.putUpdateUser(id,json);

    }
}

package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USER = Constant.BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL + "/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL + "/api/users/{id}";
    public static String LOGIN_USER = Constant.BASE_URL + "/api/login";
    public static String REGISTER_USER = Constant.BASE_URL + "/api/register";
    public static String SINGLE_USER = Constant.BASE_URL+"/api/users/{id}" ;

    @Step("Get list users")
    public void getListUsers(int page) {
        SerenityRest.given().pathParams(ReqresResponses.PAGE, page);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json) ;
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParams("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given().pathParams("id", id);
    }

    @Step("Get list users")
    public void getListUsersInvalid(String page) {
        SerenityRest.given().pathParams("page", page);
    }

    @Step("Delete user invalid id")
    public void deleteUserInvalid(String id) {
        SerenityRest.given().pathParams("id", id);
    }
    @Step("Get single users")
    public void getSingleUsers(int id) {
        SerenityRest.given().pathParams(ReqresResponses.DATA_ID, id);
    }
    @Step("Get invalid single users")
    public void getSingleUsersInvalid(String id) {
        SerenityRest.given().pathParams(ReqresResponses.DATA_ID, id);
    }
}

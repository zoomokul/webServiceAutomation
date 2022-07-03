package trelloServiceTest.webServiceAutomation;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import trelloServiceTest.TestData.TestDataTrello;
import trelloServiceTest.testBase.TestBaseTrello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class TrelloAPITest extends TestBaseTrello {
    Response response;
    TestDataTrello data= new TestDataTrello();

    List<String> cardId=new ArrayList<>();
    public static String boardId;
    public static String listId;


    @Test
    @Order(1)
    public void create_a_board(){

        spec.pathParams("first",1,"second","boards");

//contentType(ContentType.JSON)

        HashMap<String,String> postBodyMap=data.postBoardData();
        response=given().
                contentType(ContentType.JSON).
                spec(spec).body(postBodyMap).when().
                post("/{first}/{second}");


        response.prettyPrint();

        JsonPath jsonPath= response.jsonPath();

        boardId=jsonPath.get("id");


    }

    @Test
    @Order(2)
    public void create_a_list(){

        spec.pathParams("first",1,"second","lists");
        HashMap<String,String> postBodyMap=data.postListData();

        response=given()
                .contentType(ContentType.JSON).spec(spec).
                        body(postBodyMap).when().post("/{first}/{second}");

        response.prettyPrint();

        JsonPath jsonPath= response.jsonPath();

        listId=jsonPath.get("id");


    }

    @Test
    @Order(3)
    public void create_two_card(){

        spec.pathParams("first",1,"second","cards");
        HashMap<String,String> postBodyMap=data.postCardData();

        for (int i = 0; i <2 ; i++) {

            response = given()
                    .contentType(ContentType.JSON).spec(spec).body(postBodyMap).
                            when().post("/{first}/{second}");


            response.prettyPrint();

            JsonPath jsonPath = response.jsonPath();

            cardId.add(jsonPath.getString("id"));
        }


    }

    @Test
    @Order(4)
    public void update_a_card(){

        Random rd= new Random();
        int sayi=rd.nextInt(cardId.size());

        spec.pathParams("first",1,"second","cards","cardId",cardId.get(sayi));
        HashMap<String,String> updateBodyMap=data.updateData();

        response=given()
                .contentType(ContentType.JSON).spec(spec).body(updateBodyMap).when().
                        put("/{first}/{second}/{cardId}");

        response.prettyPrint();

    }

    @Test
    @Order(5)
    public void delete_cards(){

        for (int i = 0; i < cardId.size(); i++) {
            spec.pathParams("first", 1, "second", "cards", "cardId", cardId.get(i));

            HashMap<String, String> deleteMap = data.delete();
            response = given()
                    .contentType(ContentType.JSON).spec(spec).body(deleteMap).when().delete("/{first}/{second}/{cardId}");
        }
    }

    @Test
    @Order(6)
    public void delete_board(){
        spec.pathParams("first", 1, "second", "boards", "boardId", boardId);

        HashMap<String, String> deleteMap = data.delete();

        response=given()
                .contentType(ContentType.JSON).spec(spec).body(deleteMap).when().delete("/{first}/{second}/{boardId}");
    }
}

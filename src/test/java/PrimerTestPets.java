import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.path.json.JsonPath.from;

public class PrimerTestPets {

    @Test
    public void getPet(){

       String response= RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("https://aeiss.gob.do/")
                .then()
                .log().all()
                .statusCode(200).extract().asString();


       /* String idPet = from(response).get("name");
        System.out.println(idPet);*/
    }

    @Test
    public void tien(){

       RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("https://automationexercise.com/api/brandsList")
                .then()
                .log().all()
                .statusCode(200).extract().asString();



    }

    @Test
    public void getStatsOfPetAvailable(){

        String response =RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then().log().all()
                .statusCode(200)
                .extract()
                .asString();

        List<Map> status = from(response).get("findAll{ gg -> gg.status == 'available'}");

       // int idPet = from(response).get("status");

        String nam= status.get(0).get("name").toString();

        for(Map US : status){
            System.out.println(US);
        }

        System.out.println("nameeeeeeeeee:"+nam);



    }


    @Test
    public void postSearchPorduct(){



        String response= RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("search_product","jean")
                .when()
                .post("https://automationexercise.com/api/searchProduct")
                .then()
                .log().all()
                .statusCode(200).extract().asString();


        String idPet = from(response).get("name");
        System.out.println(idPet);
    }
    @Test
    public void getListPorducts(){



       RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("https://automationexercise.com/api/productsList")
                .then()
                .log().all()
                .statusCode(200);



    }
    @Test
    public void getListBrands(){



        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("https://automationexercise.com/api/brandsList")
                .then()
                .log().all()
                .statusCode(200);



    }
    // estos no siven, la pagina no tieene documentacion suficiente
    @Test
    public void postListProduct(){



        RestAssured
                .given()
                .contentType(ContentType.JSON)

                .pathParam("search_product","Soft Stretch Jeans")

                .when()
                .post("https://automationexercise.com/api/searchProduct/search_product/{search_product}")
                .then()
                .log().all()
                .statusCode(200);



    }
    @Test
    public void postCreatAccount(){



        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n"+
                        "\"name\":\"juanSOta\",\n"+
                        "\"email\":\"obedsilvestre339@gmail.com\"\n"+
                        "\"title\":\"Mr\"\n"+
                        "\"birth_date\":\"16\"\n"+
                        "\"birth_month\":\"1\"\n"+
                        "\"birth_year\":\"1999\"\n"+
                        "\"firstname\":\"juan\"\n"+
                        "\"lastname\":\"gomes\"\n"+
                        "\"company\":\"os\"\n"+
                        "\"address1\":\"mexico\"\n"+
                        "\"address2\":\"sandiego\"\n"+
                        "\"zipcode\":\"112344\"\n"+
                        "\"state\":\"sanama\"\n"+
                        "\"city\":\"monte rey\"\n"+
                        "\"mobile_number\":\"8093763454\"\n"+
                        "}")
                .when()
                .post("https://automationexercise.com/api/createAccount")
                .then()
                .log().all()
                .statusCode(200);



    }
    @Test
    public void deletAccuend(){



        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("email","hubergamer12@gmail.com")
                //.pathParam("password","Saitama")
                .when()
                .delete("https://automationexercise.com/api/deleteAccount/hubergamer12@gmail.com/Saitama")
                .then()
                .log().all()
                .statusCode(200);



    }
    // hasta aqui

    @Test
    public void getOneEpisodioAboutRick (){

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://rickandmortyapi.com/api/character/106")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);
    }

}

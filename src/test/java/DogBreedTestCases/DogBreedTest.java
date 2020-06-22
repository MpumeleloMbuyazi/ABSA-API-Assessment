package DogBreedTestCases;

import static io.restassured.RestAssured.*;

import com.aventstack.extentreports.Status;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;

public class DogBreedTest extends BaseClass{

    @BeforeSuite
    public void generateReport(){

        report();
    }

    //Displays list of all dog breeds.
    @Test(priority = 1)
    public void dogBreeds(){

        ext = test.createTest("Dog Breed list");

            baseURI = "https://dog.ceo/api/breeds";
            given()
                    .get("/list")
                    .then()
                    .statusCode(200).log().all();

    }

    //Displays random link for the sub-breed "golden".
    @Test(priority = 4)
    public void subBreedsImages(){

        ext = test.createTest("Display random image link for the golden retriever");

            baseURI = "https://dog.ceo/api/breed/retriever/golden/images/";
            given()
                    .get("/random")
                    .then()
                    .statusCode(200).log().all();

    }

    //Verifies the sub-breeds for the retriever.
    @Test(priority = 2)
    public void subBreeds(){

        ext = test.createTest("Verify the sub-breed of the retriever");

            baseURI = "https://dog.ceo/api/breed/retriever/";
            given()
                    .get("/list")
                    .then()
                    .statusCode(200).log().all();

    }

    //Verify that retriever breed is on the dog breed list
    @Test(priority = 3)
    public void verifyBreed(){

        ext = test.createTest("Verify retriever is on breed list");

            given()
                    .get("https://dog.ceo/api/breeds/list")
                    .then()
                    .body("message",hasItem("retriever")).statusCode(200);

    }

    @AfterSuite
    public void flushReport(){
        test.flush();
    }

}





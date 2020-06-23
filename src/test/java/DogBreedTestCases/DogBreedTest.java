package DogBreedTestCases;
import static io.restassured.RestAssured.*;
import Utilities.ExcelUtils;
import com.aventstack.extentreports.Status;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;
import java.io.IOException;

public class DogBreedTest extends BaseClass{

    //This Method creates Extent Report
    @BeforeSuite
    public void generateReport(){

        report();
    }

    //Displays list of all dog breeds.
    @Test(priority = 1)
    public void dogBreeds(){

        ext = test.createTest("Dog Breed list");

        //Performing a GET request to produce a list of all dog breeds
            baseURI = "https://dog.ceo/api/breeds";
            given()
                    .get("/list/all")
                    .then()
                    .statusCode(200).log().all();

    }

    //Displays random link for the sub-breed "golden".
    @Test(priority = 4)
    public void subBreedsImages(){

        ext = test.createTest("Display random image link for the golden retriever");

            //Performing a GET request to produce a random image link for the sub-breed “golden"
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

            //Performing a GET request to produce a list of sub-breeds for “retriever"
            baseURI = "https://dog.ceo/api/breed/retriever/";
            given()
                    .get("/list")
                    .then()
                    .statusCode(200).log().all();
    }

    //Verify that retriever breed is on the dog breed list
    @Test(priority = 3)
    public void verifyBreed() throws IOException {

        ext = test.createTest("Verify retriever is on breed list");

        //Performing a GET request to verify “retriever” breed is within the list.
            given()
                    .get("https://dog.ceo/api/breeds/list")
                    .then()
                    .body("message",hasItem("retriever")).statusCode(200);

    }

    //This Method Generates the extent report
    @AfterSuite
    public void flushReport(){
        test.flush();
    }

}





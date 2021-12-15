package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class Utils {

    public static RequestSpecification req;
    static String associateID;
    String token;

    public String getToken() {

        String tokenresponse = given().headers("Authorization", "Basic VEVTVFIwMDAwMTpQQHNzdzByZA==").headers("programme-identifier", "BAEC")
                .queryParam("grant_type", "client_credentials")
                .when().log().all().post("https://authint.avios.com/v3/secure/issueToken").asString();

        JsonPath js = new JsonPath(tokenresponse);
        token = js.getString("access_token");
        return token;
    }


    public RequestSpecification getRequestSpecification() throws IOException {

        if (req == null) {

            PrintStream print = new PrintStream(new FileOutputStream("log.txt"));
            req = new RequestSpecBuilder()
                    .setBaseUri(getBaseURI())
                    .addHeader("Authorization", getToken())
                    .addHeader("api_key", "h73gngnyachm3tft6fqbvahj")
                    .addFilter(RequestLoggingFilter.logRequestTo(print))
                    .addFilter(ResponseLoggingFilter.logResponseTo(print))
                    .setContentType(ContentType.JSON)
                    .build();
            return req;
        }

        return req;
    }


    public String getBaseURI() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\n480555\\Documents\\E2EAutomation\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty("baseURL");


    }

    public String getAssociateID(String location) {

        String[] splitValue = location.split("associates/");
        String associateID = splitValue[1];

        return associateID;
    }


    public String getJsonPath(String responseComplete, String memberIdentifier) {
        JsonPath js = new JsonPath(responseComplete);
        String keyValue = js.getString("memberIdentifier");
        return keyValue;
    }
}

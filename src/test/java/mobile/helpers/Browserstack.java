package mobile.helpers;

import static mobile.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.proxy;
import static java.lang.String.format;

    public class Browserstack {

        public static String getVideoUrl(String sessionId) {
            String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

            return given()
                    .log().all()
                    .filter(withCustomTemplates())
                    .auth().basic(proxy.getUsername(), proxy.getPassword())
                    .when()
                    .get(url)
                    .then()
                    .log().all()
                    .statusCode(200)
                    .extract().path("automation_session.video_url");
        }
    }

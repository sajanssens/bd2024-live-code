package com.infosupport;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infosupport.domain.Contact;
import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jupiter.MicroShedTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicroShedTest
@SharedContainerConfig(AppDeploymentConfig.class)
class AppIT {
    private static final Gson gson = new GsonBuilder().create();

    @Test
    void whenPostAndGetAangiftesIsCalledItWorks() {
        var a = Contact.builder().firstName("firstName").surname("surname").build();

        var contact = given().contentType("application/json")
                .header("Authorization", "true")
                .body(gson.toJson(a))
                .when().post("/api/contacts")
                .then().statusCode(200)
                .extract().response();

        var contacts =
                given().contentType("application/json")
                        .when().get("/api/contacts")
                        .then().statusCode(200)
                        .extract().response();

        assertTrue(contact.asPrettyString().contains("id"));
        assertNotNull(contacts.getBody());
        assertTrue(contacts.asPrettyString().contains("firstName"));
        assertTrue(contacts.asPrettyString().contains("surname"));
    }
}

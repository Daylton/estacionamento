package com.daylton.estacionamento.controller;

import com.daylton.estacionamento.controller.dto.ParkingCreateDTO;
import com.google.common.net.MediaType;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTestIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    void whenCreateThenChackIsCreated() {

        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("AZUL");
        createDTO.setLicense("RTY-0000");
        createDTO.setModel("Astra");
        createDTO.setState("PB");

        RestAssured.given()
                .when()
                .contentType(String.valueOf(MediaType.JSON_UTF_8))
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("license", Matchers.equalTo("RTY-0000"))
                .body("color", Matchers.equalTo("AZUL"));
    }
}
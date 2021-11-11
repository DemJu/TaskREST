package ru.DemJu.client.impl;

import io.restassured.RestAssured;
import ru.DemJu.client.AccessSystem;
import ru.DemJu.entity.InfoRooms;
import ru.DemJu.entity.InfoUser;

public class AccessSystemImpl implements AccessSystem {
    private static final String BASE_URL = "http://localhost:8080";

    @Override
    public String getPeopleCheck(String entrance, Integer keyId, Integer roomId) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .param("entrance", entrance)
                .param("keyId", keyId)
                .param("roomId", roomId)
                .request("GET", "/check")
                .body()
                .prettyPeek()
                .asString();
    }

    @Override
    public InfoRooms getInfoRooms() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .request("GET", "/info/rooms")
                .body()
                .prettyPeek()
                .as(InfoRooms[].class)[0];
    }

    @Override
    public InfoUser getUser(Integer end, Integer start) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .param("end", end)
                .param("start", start)
                .request("GET", "/info/users")
                .body()
                .prettyPeek()
                .as(InfoUser[].class)[0];
    }
}

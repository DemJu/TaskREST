package ru.DemJu.client.impl;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.DemJu.client.AccessSystem;
import ru.DemJu.entity.InfoRooms;
import ru.DemJu.entity.InfoUser;
import ru.ReturnClass;

public class AccessSystemImpl implements AccessSystem {
    private static final String BASE_URL = "http://localhost:8080";

    @Override
    public ReturnClass statusGetPeopleCheck(String entrance, Integer keyId, Integer roomId) {
        Response response = RestAssured.given()
                .baseUri(BASE_URL)
                .param("entrance", entrance)
                .param("keyId", keyId)
                .param("roomId", roomId)
                .request("GET", "/check");
        String str = response.body()
                .prettyPeek()
                .asString();
        return new ReturnClass(str, response.statusCode());
    }

    @Override
    public ReturnClass statusGetInfoRooms() {
        Response response = RestAssured.given()
                .baseUri(BASE_URL)
                .request("GET", "/info/rooms");
        InfoRooms infoRooms = response.body()
                .as(InfoRooms[].class)[0];
        return new ReturnClass(infoRooms, response.statusCode());
    }

    @Override
    public ReturnClass statusGetUser(Integer end, Integer start) {
        Response response = RestAssured.given()
                .baseUri(BASE_URL)
                .param("end", end)
                .param("start", start)
                .request("GET", "/info/users");
        InfoUser[] infoUser = response.body()
                .as(InfoUser[].class);
        return new ReturnClass(infoUser, response.statusCode());
    }
}

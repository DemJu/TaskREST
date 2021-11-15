package ru.DemJu.client;

import ru.ReturnClass;

public interface AccessSystem {
    ReturnClass statusGetInfoRooms();

    ReturnClass statusGetPeopleCheck(String entrance, Integer keyId, Integer roomId);

    ReturnClass statusGetUser(Integer end, Integer start);
}

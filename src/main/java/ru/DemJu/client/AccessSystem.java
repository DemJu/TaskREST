package ru.DemJu.client;

import ru.DemJu.entity.InfoRooms;
import ru.DemJu.entity.InfoUser;

public interface AccessSystem {
    InfoRooms getInfoRooms();

    String getPeopleCheck(String entrance, Integer keyId, Integer roomId);

    InfoUser getUser(Integer end, Integer start);
}

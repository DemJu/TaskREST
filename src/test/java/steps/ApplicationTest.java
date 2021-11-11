package steps;

import io.cucumber.java.en.Given;
import ru.DemJu.client.AccessSystem;
import ru.DemJu.client.impl.AccessSystemImpl;
import ru.DemJu.entity.InfoRooms;
import ru.DemJu.entity.InfoUser;

public class ApplicationTest {
    private final AccessSystem accessSystem = new AccessSystemImpl();

    @Given("^I \"(.+)\" room \"(.+)\" with key \"(.+)\"$")
    public void interactionRoom(String entrance, Integer roomId, Integer keyId) {
        String people = accessSystem.getPeopleCheck(entrance, keyId, roomId);
    }

    @Given("^I'll find out about the rooms$")
    public void infoRooms() {
        InfoRooms rooms = accessSystem.getInfoRooms();
    }

    @Given("^I am checking user information with the beginning of report \"(.+)\" and the end of \"(.+)\"$")
    public void infoUsers(Integer start, Integer end) {
        InfoUser users = accessSystem.getUser(end, start);
    }
}

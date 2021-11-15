package steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import ru.DemJu.client.AccessSystem;
import ru.DemJu.client.impl.AccessSystemImpl;
import ru.ReturnClass;

public class ApplicationTest {
    private final AccessSystem accessSystem = new AccessSystemImpl();

    @Given("^I \"(.+)\" room \"(.+)\" with key \"(.+)\"$")
    public void interactionRoom(String entrance, Integer roomId, Integer keyId) {
        ReturnClass returnClass = accessSystem.statusGetPeopleCheck(entrance, keyId, roomId);
        Assert.assertTrue(200 == (Integer) returnClass.getSecond());
    }

    @Given("^I'll find out about the rooms$")
    public void infoRooms() {
        ReturnClass returnClass = accessSystem.statusGetInfoRooms();
        Assert.assertTrue("", 200 == (Integer) returnClass.getSecond());
    }

    @Given("^I am checking user information with the beginning of report \"(.+)\" and the end of \"(.+)\"$")
    public void infoUsers(Integer start, Integer end) {
        ReturnClass returnClass = accessSystem.statusGetUser(end, start);
        Assert.assertTrue(200 == (Integer) returnClass.getSecond());
    }
}

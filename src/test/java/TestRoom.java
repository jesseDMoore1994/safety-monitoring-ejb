import java.io.PrintStream;
import java.util.*;
import safety_monitoring.Room;
import safety_monitoring.Door;
import safety_monitoring.Window;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
 
class RoomTest {
 
    @Test
    void testGetName() {
        Room testRoom = new Room("my room");
		assertEquals(testRoom.getName(), "my room");
    }
 
    @Test
    void testDoorList() {
        Room testRoom = new Room("my room");
        Door door1 = new Door("Door1", 1);
        Door door2 = new Door("Door2", 1);
        testRoom.addDoor(door1);
        testRoom.addDoor(door2);
		assertEquals(testRoom.getDoorByName("Door1"), door1);
		assertEquals(testRoom.getDoorByName("Door2"), door2);
    }
 
    @Test
    void testWindowList() {
        Room testRoom = new Room("my room");
        Window window1 = new Window("test0", 1);
        Window window2 = new Window("test1", 1);
        testRoom.addWindow(window1);
        testRoom.addWindow(window2);
		assertEquals(testRoom.getWindowByName("test0"), window1);
		assertEquals(testRoom.getWindowByName("test1"), window2);
    }
}

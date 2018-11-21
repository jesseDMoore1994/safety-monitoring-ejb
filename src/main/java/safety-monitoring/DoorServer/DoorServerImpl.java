package safety_monitoring;
import java.util.ArrayList;
import javax.ejb.Stateful;
@Stateful
public class DoorServerImpl implements DoorServer {
	private ArrayList<Door> doorList = new ArrayList<Door>();

    public DoorServerImpl() {
        doorList.add(new Door("EntryDoor", 1000));
        doorList.add(new Door("VIPDoor", 1000));
    }
	
	public String getDoorState(String door_sensor) {
		// See if we have heard from this sensor. If so, get a reference to it
		Door targetDoor = null;
		for ( Door door : doorList) {
			if(door.getName().equals(door_sensor)) {
				targetDoor = door;
			}
		}
		if (targetDoor == null){
			// we haven't heard from this sensor before.
			return door_sensor+" is not currently being monitored";
		}
		// return the current state of the door
		return targetDoor.getState();
	}
}

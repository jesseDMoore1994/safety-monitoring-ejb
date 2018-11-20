package safety_monitoring;
import java.util.HashMap;
import javax.ejb.Stateful;
@Stateful
public class DoorServerImpl implements DoorServer {
	private HashMap<String, safety_monitoring.Door> DoorList = new HashMap<String, safety_monitoring.Door>();
	
	public String getDoorState(String door_sensor) {
	    // See if we have heard from this sensor. If so, get a reference to it
	    Door targetDoor = DoorList.getOrDefault(door_sensor, null);
	    if (targetDoor == null){
	        // if we don't know about this door, inform the caller
	        return door_sensor+" is not currently being monitored.";
	    } else {
	        // get the door's state
	        return targetDoor.getState();
	    }
	}
	
	public boolean addDoor(String door_sensor) {
		// see if the sensor is in the list already
	    Door targetDoor = DoorList.getOrDefault(door_sensor, null);
	    if (targetDoor == null){
	        // if the door wasn't found, add it
	        Door newDoor = new Door(door_sensor, 1000);
	        DoorList.put(door_sensor, newDoor);
	        targetDoor = newDoor;
	    } 
		return targetDoor != null;
	}
}

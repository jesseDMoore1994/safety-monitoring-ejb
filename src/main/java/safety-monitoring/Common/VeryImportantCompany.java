package safety_monitoring;
import java.util.*;

//VeryImportantCompany is a Singleton class since there can only be one VeryImportantCompany

//The very important company is made up of two rooms, VIP Room an receptionist Room
//There are two windows and two doors, the VIP room has both windows (window 0 and 1),
//and it shares a door with the receptionist room ("VIP Door"). The Receptionist room
//has another door called "Entry Door" in addition to the VIP Door. The receptionist 
//Room does not have any windows.
public class VeryImportantCompany {

  //list of rooms
  private ArrayList<Room> rooms = new ArrayList<Room>();
  private HashMap<String, Door> DoorDict = new HashMap<String, Door>();
  //there is only one possible instance of VeryImportantCompany, so we have a static reference
  private static VeryImportantCompany singleInstance = null;

  //the constructor is private so it can only be called by the class itself
  private VeryImportantCompany(){
      //create windows for simulation
      Window window1 = new Window("VIPWindowNorth", 1000);
      Window window2 = new Window("VIPWindowEast", 1000);

      //create doors for sumulation
      Door entryDoor = new Door("Entry Door", 1000);
      Door vipDoor = new Door("VIP Door", 1000);

      //create the rooms for the simulation
      Room receptionistRoom = new Room("Receptionist Room");
      Room vipRoom = new Room("VIP Room");

      //add the doors to the receptionist room
      receptionistRoom.addDoor(entryDoor);
      receptionistRoom.addDoor(vipDoor);

      //add the door and windows to the vip room
      vipRoom.addDoor(vipDoor);
      vipRoom.addWindow(window1);
      vipRoom.addWindow(window2);

      //add doors to door dictionary
      DoorDict.put("Entry Door", entryDoor);
      DoorDict.put("VIP Door", vipDoor);

      //finally, add the rooms to very important companies list of rooms
      rooms.add(receptionistRoom);
      rooms.add(vipRoom);
  }

  //this function will return a room with a name equal to the argument
  //if it exists, otherwise it will return null
  public Room getRoomByName(String roomName) {
      for ( Room room : rooms ) {
          if(room.getName().equals(roomName)) {
              return room;
          }
      }
      return null;
  }

  public ArrayList<Window> getWindows(){
		ArrayList<Window> allWindows = new ArrayList<Window>();
		for (Room room: rooms){
			for (Window window: room.getWindows()){
				if (!allWindows.contains(window)){
					allWindows.add(window);
				}
			}
		}
		return allWindows;
    }
    
    public HashMap<String, Door> getDoors(){
        return DoorDict;
    }

  //this function will return the state of the window with a name that matches the argument
  //from the VIP Room if it exists, otherwise it try to get a window and fail. We catch
  //the error and return an error string.
  //We do not use the receptionist room because it has no windows.
  public String getWindowStatus(String windowName) {
      //get window reference
      Window targetWindow = getRoomByName("VIP Room").getWindowByName(windowName);
      //if targetWindow is null then a window by that name does not exist
      if(targetWindow == null) {
          //return error string
          return "No window by name "+windowName+" exists.";
      } else {
          //return the target window state
          return targetWindow.getState();
      }      
  }
  
  //this function will return the state of the door with the name equal to the argument
  //from the Receptionist Room if it exists, otherwise it try to get a door and get a null
  //value. If the value is null then we return an error string.
  //We use the receptionist room since it has two doors.
  public String getDoorStatus(String doorName) {
      //get target door from room
      Door targetDoor = getRoomByName("Receptionist Room").getDoorByName(doorName);
      //if targetDoor is null then the room name does not exist
      if(targetDoor == null) {
          //return error string
          return "Target door does not exist.";
      } else {
          //return the target door state
          return targetDoor.getState();
      }
  }

  public HashMap<String, Door> GetDoorList(){
      return this.DoorDict;
  }

  //this is the factory method for the singleton behavior
  public static VeryImportantCompany getInstance() {
      //if we do not have an instance of the class, create it
      if (singleInstance == null)
          singleInstance = new VeryImportantCompany();
      //return the instance
      return singleInstance;
  }
}

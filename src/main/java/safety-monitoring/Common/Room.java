package safety_monitoring;
import java.util.*;

//A Room is just a collection of Doors and Windows with an associated name
public class Room {

  //list of Doors in room
  private ArrayList<Door> doors = new ArrayList<Door>();
  //list of Windows in room
  private ArrayList<Window> windows = new ArrayList<Window>();
  //room name
  private String name;

  //when you create the room assign the name
  public Room(String name) {
      this.name = name;
  }
  
  public ArrayList<Window> getWindows(){
	  return windows;
  }
  
  public ArrayList<Door> getDoors(){
	  return doors;
  }
  
  //this adds a Door Object to the Door list
  public void addDoor(Door newDoor) {
      doors.add(newDoor);
  }
  
  //this adds a Window Object to the Window list
  public void addWindow(Window newWindow) {
      windows.add(newWindow);
  }

  //this function returns the door name
  public String getName() {
      return name;
  }

  //this function returns a Door object with name equal to the argument string
  //if it exists, otherwise it returns null
  public Door getDoorByName(String name) {
      for ( Door door : doors) {
          if(door.getName().equals(name)) {
              return door;
          }
      }
      return null;
  }

  //this function returns a Window object with an index equal to the argument int
  //if it exists, otherwise it returns null
  public Window getWindowByName(String windowName) {
    for ( Window window : windows) {
        if(window.getName().equals(name)) {
            return window;
        }
    }
    return null;
  }
}

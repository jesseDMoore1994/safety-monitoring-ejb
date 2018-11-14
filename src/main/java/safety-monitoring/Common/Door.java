package safety_monitoring;
import java.util.*;

//This is a class that is used to represnt the functionality of a Door object
public class Door {

  //list of all possible door states
  private ArrayList<String> doorStates = new ArrayList<String>();
  //current state of Door
  private String currentDoorState = new String();
  //random number generator
  private Random randGen = new Random();
  //timer object used to keep time
  private Timer stateTimer = new Timer();
  //name of the door
  private String doorName;

  //an internal private class that is used to change state on an interval
  private static class MyDoorTimeTask extends TimerTask
  {
      private Door myDoor;
      //when we create the timer task we pass in a reference to our door
      MyDoorTimeTask(Door myDoor) {
          this.myDoor = myDoor;
      }
      //run is the function executed when the timer interval triggers
      public void run()
      {
          //so when the interval triggers we change state
          this.myDoor.changeState();
      }
  }

  //Door constructor takes door name and the timer interval for state change
  public Door(String doorName, long period){
    //add in all the possible door states
    doorStates.add("Open.");
    doorStates.add("Closed but not Locked.");
    doorStates.add("Closed and Locked.");
    //set the door name
    this.doorName = doorName;
    //initialize door state
    changeState();
    //set interval timer to execute the run function of MyDoorTimeTask passing in our door reference
    stateTimer.schedule(new MyDoorTimeTask(this), 0, period);
  }
  
  //get the name of the door
  public String getName() {
    return doorName;
  }
  
  //get the current state of the door
  public String getState() {
    return currentDoorState;
  }
  
  //change the current state of the door
  public void changeState() {
    //this code basically sets door state by generating an integer between [0, MAX_STATES) and getting that index
    currentDoorState = doorStates.get(randGen.nextInt(doorStates.size()));
  }

}

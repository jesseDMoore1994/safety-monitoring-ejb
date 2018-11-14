package safety_monitoring;
import java.util.*;

//This is a class that is used to represent the functionality of a Window object
public class Window {

  //list of all possible window states
  private ArrayList<String> windowStates = new ArrayList<String>();
  //current state of Window
  private String currentWindowState = new String();
  //random number generator
  private Random randGen = new Random();
  //timer object used to keep time
  private Timer stateTimer = new Timer();
  //index of the door
  private String windowName;

  //an internal private class that is used to change state on an interval
  private static class MyWindowTimeTask extends TimerTask
  {
      private Window myWindow;
      //when we create the timer task we pass in a reference to our window
      MyWindowTimeTask(Window myWindow) {
          this.myWindow = myWindow;
      }
      //run is the function executed when the timer interval triggers
      public void run()
      {
          //so when the interval triggers we change state
          this.myWindow.changeState();
      }
  }

  //Door constructor takes window name and the timer interval for state change
  public Window(String windowName, long period){
    //add in all the possible window states
    windowStates.add("Open.");
    windowStates.add("Half Open.");
    windowStates.add("Closed but not Locked.");
    windowStates.add("Closed and Locked.");
    //set the window  name
    this.windowName = windowName;
    //initialize window state
    changeState();
    //set interval timer to execute the run function of MyWindowTimeTask passing in our window reference
    stateTimer.schedule(new MyWindowTimeTask(this), 0, period);
  }
  
  //get the name of the window
  public String getName() {
    return windowName;
  }
  
  //get the current state of the window
  public String getState() {
    return currentWindowState;
  }
  
  //change the current state of the window
  public void changeState() {
    //this code basically sets window state by generating an integer between [0, MAX_STATES) and getting that index
    currentWindowState = windowStates.get(randGen.nextInt(windowStates.size()));
  }

}

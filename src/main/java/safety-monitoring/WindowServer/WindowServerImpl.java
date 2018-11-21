package safety_monitoring;
import java.util.ArrayList;
import javax.ejb.Stateful;
@Stateful
public class WindowServerImpl implements WindowServer {
	private ArrayList<Window> windowList = new ArrayList<Window>();

    public WindowServerImpl() {
        windowList.add(new Window("VIPWindowNorth", 1000));
        windowList.add(new Window("VIPWindowEast", 1000));
    }

	public String getWindowState(String window_sensor) {		
		// See if we have heard from this sensor. If so, get a reference to it
		Window targetWindow = null;
		for ( Window window : windowList) {
			if(window.getName().equals(window_sensor)) {
				targetWindow = window;
			}
		}
		if (targetWindow == null){
			// we haven't heard from this sensor before.
			return window_sensor+" is not currently being monitored";
		}
		// return the current state of the window
		return targetWindow.getState();
	}
}

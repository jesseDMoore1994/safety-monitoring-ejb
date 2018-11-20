package safety_monitoring;
import java.util.*;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import safety_monitoring.WindowServer;
import safety_monitoring.DoorServer;

public class PopulateServers{
	public static void main(String[] args) throws Exception {
	Context ic= new InitialContext();
	
	Object object_ref = ic.lookup("java:global/safety-monitoring-ejb-1.0.0/DoorServerImpl");
	DoorServer DoorServerProxy= (DoorServer) PortableRemoteObject.narrow(object_ref,DoorServer.class);
	
	Object object_ref2 = ic.lookup("java:global/safety-monitoring-ejb-1.0.0/WindowServerImpl");
	WindowServer WindowServerProxy= (WindowServer) PortableRemoteObject.narrow(object_ref2,WindowServer.class);
	
	//populate Windows
	ArrayList<String> window_names = new ArrayList<String>();
    window_names.add("VIPWindowNorth");
    window_names.add("VIPWindowEast");
	for (String window: window_names){
		if(WindowServerProxy.addWindow(window)){
			System.out.println("Added "+window);
		} else {
			System.out.println("Failed to add "+window);
		}
	}
	
	//populate Doors
	ArrayList<String> door_names = new ArrayList<String>();
    door_names.add("VIP Door");
    door_names.add("Entry Door");
	for (String door: door_names){
		if(DoorServerProxy.addDoor(door)){
			System.out.println("Added "+door);
		} else {
			System.out.println("Failed to add "+door);
		}
	}
	//call System.exit to ensure the program ends
	System.exit(0);
	}
}

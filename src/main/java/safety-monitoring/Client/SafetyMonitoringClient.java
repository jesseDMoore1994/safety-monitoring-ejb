package safety_monitoring;
import java.util.*;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import safety_monitoring.WindowServer;
import safety_monitoring.DoorServer;

public class SafetyMonitoringClient{
	public static void main(String[] args) throws Exception {
	Context ic= new InitialContext();
	
	Object object_ref = ic.lookup("java:global/safety-monitoring-ejb-1.0.0/DoorServerImpl");
	DoorServer DoorServerProxy= (DoorServer) PortableRemoteObject.narrow(object_ref,DoorServer.class);
	
	Object object_ref2 = ic.lookup("java:global/safety-monitoring-ejb-1.0.0/WindowServerImpl");
	WindowServer WindowServerProxy= (WindowServer) PortableRemoteObject.narrow(object_ref2,WindowServer.class);
	
        //If the first arg is the string "Window", we are selecting from the window interface
        if(args[0].equals("Window"))
        {
            //use the wsdl interface and print out the response
	        String response = WindowServerProxy.getWindowState(args[1]);
            System.out.println(response);
        } else if (args[0].equals("Door")) //If the first arg is the string "Door", we are selecting from the door interface
        {
            //use the wsdl interface and print out the response
	        String response = DoorServerProxy.getDoorState(args[1]);
            System.out.println(response);
        } else { //else we have an incorrect argument, print out an error
            String errStr = "First argument not recognized, select door sensors with the string ";
			errStr += "\"Door\" or window sensors with the string \"Window\" as the first argument. ";
            System.out.println(errStr);
		}
		//call System.exit to ensure the program ends
		System.exit(0);
	}
}

package safety_monitoring;

import javax.xml.ws.Endpoint;
import safety_monitoring.DoorServerPublisher;
import safety_monitoring.WindowServerPublisher;
import safety_monitoring.VeryImportantCompany;
 
//This is the main entrypoint launching the server code for the safety monitoring project
public class ServerLauncher{
    //main function
	public static void main(String[] args) {
       //initialize the very important company simulation
       //VeryImportantCompany vic = VeryImportantCompany.getInstance();

       //create the web service publishers for the doors and windows
	   DoorServerPublisher doors =  new DoorServerPublisher();
	   WindowServerPublisher windows =  new WindowServerPublisher();

       //start publishing on the two services, effectively kicking off both servers
       doors.publish();
       windows.publish();
    }
 
}

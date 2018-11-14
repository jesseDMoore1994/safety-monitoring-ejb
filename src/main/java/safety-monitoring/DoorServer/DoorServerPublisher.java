package safety_monitoring;
import javax.xml.ws.Endpoint;
import safety_monitoring.DoorServer;
 
//Endpoint publisher
public class DoorServerPublisher{
 
	public static void publish() {
	   Endpoint.publish("http://localhost:8080/door", new DoorServerImpl());
    }
 
}

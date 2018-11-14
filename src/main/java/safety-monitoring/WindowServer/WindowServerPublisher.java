package safety_monitoring;

import javax.xml.ws.Endpoint;
import safety_monitoring.WindowServerImpl;
 
//Endpoint publisher
public class WindowServerPublisher{
 
	public static void publish() {
	   Endpoint.publish("http://localhost:8081/window", new WindowServerImpl());
    }
 
}

package safety_monitoring;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)

public interface DoorServer{
 
	@WebMethod String DoorServer(String name);
	@WebMethod boolean AddDoor(String name);
 
}
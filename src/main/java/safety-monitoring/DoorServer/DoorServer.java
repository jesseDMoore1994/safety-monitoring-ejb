package safety_monitoring;
import javax.ejb.Remote;
@Remote
public interface DoorServer {
  public String getDoorState(String door_sensor);
}

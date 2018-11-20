package safety_monitoring;
import javax.ejb.Remote;
@Remote
public interface WindowServer {
  public String getWindowState(String window_sensor);
  public boolean addWindow(String window_sensor);
}

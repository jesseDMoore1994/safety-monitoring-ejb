import java.io.PrintStream;
import java.util.*;
import javax.xml.ws.Endpoint;
import java.io.ByteArrayOutputStream;
import safety_monitoring.SafetyMonitoringClient;
import safety_monitoring.DoorServerPublisher;
import safety_monitoring.WindowServerPublisher;
import safety_monitoring.DoorServerImpl;
import safety_monitoring.WindowServerImpl;
import safety_monitoring.DoorServer;
import safety_monitoring.WindowServer;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.matches;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
 
class SafetyMonitoringClientTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Test
    void testExerciseWindowInterface() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
        WindowServerPublisher p = new WindowServerPublisher();
        p.publish();
        try {
            SafetyMonitoringClient.main(new String[] {"Window", "VIPWindowNorth"});
        } catch (Exception ex) {
            originalOut.println(ex.toString());
            fail();   
        }
        assertEquals("Half Open.\n", outContent.toString());
        System.setOut(originalOut);
	    System.setErr(originalErr);
    }
 
    @Test
    void testExerciseDoorInterface() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
        DoorServerPublisher p = new DoorServerPublisher();
        p.publish();
        try {
            SafetyMonitoringClient.main(new String[] {"Door", "VIP Door"});
        } catch (Exception ex) {
            originalOut.println(ex.toString());
            fail();
        }
        assertEquals("Open.\n", outContent.toString());
	    System.setOut(originalOut);
	    System.setErr(originalErr);
    }
 
    @Test
    void testServerNotSpecified() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
        try {
            SafetyMonitoringClient.main(new String[] {"VIP Door"});
        } catch (Exception ex) {
            originalOut.println(ex.toString());
            fail();
        }
        String errStr = "First argument not recognized, select door sensors with the string ";
        errStr += "\"Door\" or window sensors with the string \"Window\" as the first argument.\n";
        assertEquals(errStr, outContent.toString());
	    System.setOut(originalOut);
	    System.setErr(originalErr);
    }
}

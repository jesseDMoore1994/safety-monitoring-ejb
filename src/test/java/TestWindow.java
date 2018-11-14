import java.io.PrintStream;
import java.util.*;
import safety_monitoring.Window;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
 
class WindowTest {
 
    @Test
    void testWindowState() {
        Window testWindow = new Window("test", 1);
        ArrayList<String> capturedStates = new ArrayList<String>();
        int i = 0;
        while( capturedStates.size() != 4 ) {
            String currentState = testWindow.getState();
            if (!capturedStates.contains(currentState)) {
                capturedStates.add(currentState);
            }
            testWindow.changeState();
        }
		assertThat(capturedStates, containsInAnyOrder("Open.", "Half Open.", "Closed but not Locked.", "Closed and Locked."));
    }
}

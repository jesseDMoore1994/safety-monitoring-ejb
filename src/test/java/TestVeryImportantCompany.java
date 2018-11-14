import java.io.PrintStream;
import java.util.*;
import safety_monitoring.VeryImportantCompany;
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
 
class VeryImportantCompanyTest {

    private VeryImportantCompany vic = VeryImportantCompany.getInstance();
    private ArrayList<String> expectedWindowReturns = new ArrayList<String>();
    private ArrayList<String> expectedDoorReturns = new ArrayList<String>();


    private boolean stringInArr(String target, ArrayList<String> arr) {
        for ( String str : arr) {
            if ( str.equals(target) ) {
                return true;
            }
        }
        return false;
    }

    public VeryImportantCompanyTest () {
        expectedWindowReturns.add("Open.");
        expectedWindowReturns.add("Half Open.");
        expectedWindowReturns.add("Closed but not Locked.");
        expectedWindowReturns.add("Closed and Locked.");
        expectedDoorReturns.add("Open.");
        expectedDoorReturns.add("Closed but not Locked.");
        expectedDoorReturns.add("Closed and Locked.");
    }
 
    @Test
    void testGetWindowStatus() {
		assertTrue(stringInArr(vic.getWindowStatus("VIPWindowNorth"), expectedWindowReturns));
		assertTrue(stringInArr(vic.getWindowStatus("VIPWindowEast"), expectedWindowReturns));
		assertEquals(vic.getWindowStatus("DOS"), "Target window does not exist.");
    }
 
    @Test
    void testGetDoorStatus() {
        assertTrue(stringInArr(vic.getDoorStatus("Entry Door"), expectedDoorReturns));
        assertTrue(stringInArr(vic.getDoorStatus("VIP Door"), expectedDoorReturns));
		assertEquals(vic.getDoorStatus("Fake Door"), "Target door does not exist.");
    }
}

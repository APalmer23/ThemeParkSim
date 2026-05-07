//"["+"Thunder Mountain"+ " - Wait: " + "45" +
//                " mins, Thrill: " + "8" +
//                ", Status: " + "open"+"]"
import static org.junit.jupiter.api.Assertions.*;

class ThemeParkTrackerTest {

    @org.junit.jupiter.api.Test
    void addRide() {
        ThemeParkTracker tracker = new ThemeParkTracker();
        Ride ride1 = new Ride("Thunder Mountain", 45, 8, "open");
        Ride ride2 = new Ride("Splash Falls", 20, 5, "closed");
        tracker.addRide(ride1);
        tracker.addRide(ride2);
        ThemeParkTracker t = new ThemeParkTracker();
        t.addRide(ride1);
        t.addRide(ride2);
        assertTrue(t.getRides().containsAll(tracker.getRides())&&tracker.getRides().containsAll(t.getRides()));

    }

    @org.junit.jupiter.api.Test
    void getRide() {
        ThemeParkTracker tracker = new ThemeParkTracker();
        Ride ride1 = new Ride("Thunder Mountain", 45, 8, "open");
        Ride ride2 = new Ride("Splash Falls", 20, 5, "closed");
        tracker.addRide(ride1);
        tracker.addRide(ride2);
        assertEquals(ride1,tracker.getRide(0));
        assertNull(tracker.getRide(4));
    }

    @org.junit.jupiter.api.Test
    void removeClosedRides() {
        ThemeParkTracker tracker = new ThemeParkTracker();
        Ride ride1 = new Ride("Thunder Mountain", 45, 8, "open");
        Ride ride2 = new Ride("Splash Falls", 20, 5, "closed");
        Ride ride3 = new Ride("Dragon Coaster", 60, 10, "closed");
        ThemeParkTracker t = new ThemeParkTracker();
        t.addRide(ride1);
        tracker.addRide(ride1);
        tracker.addRide(ride2);
        tracker.addRide(ride3);
        tracker.removeClosedRides();
        assertTrue(t.getRides().containsAll(tracker.getRides())&&tracker.getRides().containsAll(t.getRides()));
        tracker.removeClosedRides();
        assertTrue(t.getRides().containsAll(tracker.getRides())&&tracker.getRides().containsAll(t.getRides()));
    }

    @org.junit.jupiter.api.Test
    void removeRide() {
        ThemeParkTracker tracker = new ThemeParkTracker();
        Ride ride1 = new Ride("Thunder Mountain", 45, 8, "open");
        Ride ride2 = new Ride("Splash Falls", 20, 5, "closed");
        Ride ride3 = new Ride("Dragon Coaster", 60, 10, "closed");
        ThemeParkTracker t = new ThemeParkTracker();
        tracker.addRide(ride1);
        tracker.addRide(ride2);
        tracker.addRide(ride3);
        t.addRide(ride2);
        t.addRide(ride3);
        tracker.removeRide(0);
        assertTrue(t.getRides().containsAll(tracker.getRides())&&tracker.getRides().containsAll(t.getRides()));
        tracker.removeRide(3);
        assertTrue(t.getRides().containsAll(tracker.getRides())&&tracker.getRides().containsAll(t.getRides()));
    }

    @org.junit.jupiter.api.Test
    void sortByWaitTime() {
        ThemeParkTracker tracker = new ThemeParkTracker();
        Ride ride1 = new Ride("Thunder Mountain", 45, 8, "open");
        Ride ride2 = new Ride("Splash Falls", 20, 5, "closed");
        Ride ride3 = new Ride("Dragon Coaster", 60, 10, "closed");
        ThemeParkTracker t = new ThemeParkTracker();
        tracker.addRide(ride1);
        tracker.addRide(ride2);
        tracker.addRide(ride3);
        t.addRide(ride2);
        t.addRide(ride1);
        t.addRide(ride3);
        tracker.sortByWaitTime();
        assertTrue(t.getRides().containsAll(tracker.getRides())&&tracker.getRides().containsAll(t.getRides()));
        tracker.sortByWaitTime();
        assertTrue(t.getRides().containsAll(tracker.getRides())&&tracker.getRides().containsAll(t.getRides()));
    }

    @org.junit.jupiter.api.Test
    void findRideStatus() {
        ThemeParkTracker tracker = new ThemeParkTracker();
        Ride ride1 = new Ride("Thunder Mountain", 45, 8, "open");
        Ride ride2 = new Ride("Splash Falls", 20, 5, "closed");
        Ride ride3 = new Ride("Dragon Coaster", 60, 10, "closed");
        assertEquals("No rides in tracker",tracker.findRideStatus("Thunder Mountain"));
        tracker.addRide(ride1);
        tracker.addRide(ride2);
        tracker.addRide(ride3);
        assertEquals("closed",tracker.findRideStatus("Splash Falls"));
        assertEquals("Ride not found",tracker.findRideStatus("no"));
    }
}
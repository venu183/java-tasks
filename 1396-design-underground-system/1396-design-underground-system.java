import java.util.*;

class UndergroundSystem {

    // id -> [stationName, checkInTime]
    private Map<Integer, Pair> checkIns;

    // "start#end" -> [totalTime, numberOfTrips]
    private Map<String, double[]> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair checkIn = checkIns.get(id);

        String route = checkIn.station + "#" + stationName;
        double travelTime = t - checkIn.time;

        if (!trips.containsKey(route)) {
            trips.put(route, new double[]{0, 0});
        }

        double[] data = trips.get(route);
        data[0] += travelTime;  // total time
        data[1]++;              // number of trips

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;

        double[] data = trips.get(route);

        return data[0] / data[1];
    }

    // Helper class
    static class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
public class Main {
    public static void main(String[] args) {
        int[][] trucks = {{1, 10, 5}, {2, 10, 7}, {3, 10, 8}}; // id, capacity, current charge level
        int[][] docks = {{1, 2}, {2, 5}, {3, 7}}; // id, charge rate
        FleetChargeScheduler fleetChargeScheduler = new FleetChargeScheduler();
        fleetChargeScheduler.createSchedule(trucks, docks, 3);
    }
}
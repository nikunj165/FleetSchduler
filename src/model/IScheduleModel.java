package model;

import model.ChargerDock;
import model.TruckInfo;

import java.util.List;

/*
    * This interface is the model interface for creating the schedule.
    * It has the following attributes:
    * chargerDockList: List of charger docks
    * truckInfoList: List of truck info
    * hours: number of hours to charge
    *
 */
public interface IScheduleModel {
    /*
        * @param chargerDockList: List of charger docks
        * @param truckInfoList: List of truck info
        * @param hours: number of hours to charge
        * @return: void
        *
        * This method creates the schedule
     */
    public void createSchedule(List<ChargerDock> chargerDockList, List<TruckInfo> truckInfoList, int hours);
}

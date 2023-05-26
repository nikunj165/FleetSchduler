package service;

import model.ChargerDock;
import model.IScheduleModel;
import model.TruckInfo;

import java.util.List;
/*
    * This class is the service class for creating the schedule.
    * It has the following attributes:
    * chargerDockList: List of charger docks
    * truckInfoList: List of truck info
    * hours: number of hours to charge
    * scheduleModel: the model to use for creating the schedule
    *
 */
public class ChargeScheduleService {
    private List<ChargerDock> chargerDockList;
    private List<TruckInfo> truckInfoList;
    private int hours;

    private IScheduleModel scheduleModel;

    public void setChargerDockList(List<ChargerDock> chargerDockList) {
        this.chargerDockList = chargerDockList;

    }

    public void setTruckInfoList(List<TruckInfo> truckInfoList) {
        this.truckInfoList = truckInfoList;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setScheduleModel(IScheduleModel scheduleModel) {
        this.scheduleModel = scheduleModel;
    }

    public void createSchedule() {
        scheduleModel.createSchedule(chargerDockList, truckInfoList, hours);
    }
}
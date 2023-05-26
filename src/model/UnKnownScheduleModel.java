package model;

import model.ChargerDock;
import model.IScheduleModel;
import model.TruckInfo;

import java.util.List;

public class UnKnownScheduleModel implements IScheduleModel {
    @Override
    public void createSchedule(List<ChargerDock> chargerDockList, List<TruckInfo> truckInfoList, int hours) {
        System.out.println("Unknown schedule model");
    }
}

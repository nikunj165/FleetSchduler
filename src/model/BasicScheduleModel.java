package model;

import model.ChargerDock;
import model.IScheduleModel;
import model.TruckInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
    * This class is the model class for creating the schedule.
    * It has the following attributes:
    * chargerDockList: List of charger docks
    * truckInfoList: List of truck info
    * hours: number of hours to charge
    *
 */
public class BasicScheduleModel implements IScheduleModel {

    /*
        * @param chargerDockList: List of charger docks
        * @param truckInfoList: List of truck info
        * @param hours: number of hours to charge
        * @return: void
        *
        * This method creates the basic schedule
     */
    public void createSchedule(List<ChargerDock> chargerDockList, List<TruckInfo> truckInfoList, int hours) {
        double[][] truckChargingDockHour = new double[truckInfoList.size()][chargerDockList.size()];
        double[] dockHours = new double[chargerDockList.size()];
        Map<Integer, List<Integer>> dockTruckMap = new HashMap<>();
        for(int i=0;i<chargerDockList.size(); i++) {
            dockHours[i] = hours;
            dockTruckMap.put(chargerDockList.get(i).getId(), new ArrayList<>());
        }
        int i=0, j;
        for (TruckInfo truckInfo : truckInfoList) {
            j=0;
            for (ChargerDock chargerDock : chargerDockList) {
                int chargeRate = chargerDock.getChargeRate();
                int currentChargeLevel = truckInfo.getCurrentChargeLevel();
                int capacity = truckInfo.getCapacity();
                double hoursToCharge = (capacity - currentChargeLevel) / (chargeRate*1.0);
                truckChargingDockHour[i][j++] = hoursToCharge;
            }
            i++;

        }
        System.out.println("Truck Charging Hours");
        for(i=0;i<truckInfoList.size();i++) {
            for(j=0;j<chargerDockList.size();j++) {
                System.out.print(truckChargingDockHour[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Dock Hours");
        for(i=0;i<chargerDockList.size();i++) {
            System.out.print(dockHours[i] + " ");
        }
        System.out.println();
        System.out.println("Dock Truck Map");
        for(i=0;i<truckInfoList.size();i++) {
            for(j=0;j<chargerDockList.size();j++) {
                if(truckChargingDockHour[i][j] < dockHours[j]) {
                    dockHours[j] -= truckChargingDockHour[i][j];
                    dockTruckMap.get(chargerDockList.get(j).getId()).add(truckInfoList.get(i).getId());
                    break;
                }
            }
        }
        for(i=0;i<chargerDockList.size();i++) {
            System.out.println("Charger Dock " + chargerDockList.get(i).getId() + " : " + dockTruckMap.get(chargerDockList.get(i).getId()));
        }
    }
}

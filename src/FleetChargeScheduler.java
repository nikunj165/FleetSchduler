import model.ChargerDock;
import model.ScheduleModelFactory;
import model.TruckInfo;
import service.ChargeScheduleService;

import java.util.ArrayList;
import java.util.List;

public class FleetChargeScheduler {
    /*
        * @param truckChargeInfo: 2D array of truck charge info
        * @param chargerDockInfo: 2D array of charger dock info
        * @param hours: number of hours to charge
        * @return: void
        *
     */
    public void createSchedule(int[][] truckChargeInfo, int[][] chargerDockInfo, int hours) {
        List<TruckInfo> truckInfoList = new ArrayList<>();
        List<ChargerDock> chargerDockList = new ArrayList<>();
        for(int[] thisTruck: truckChargeInfo) {
            TruckInfo truckInfo = new TruckInfo(); 
            
            truckInfo.setCapacity(thisTruck[1]);
            truckInfo.setId(thisTruck[0]);
            truckInfo.setCurrentChargeLevel(thisTruck[2]);
            truckInfoList.add(truckInfo);
        }
        for(int[] thisDock: chargerDockInfo) {
            ChargerDock chargerDock = new ChargerDock();
            chargerDock.setId(thisDock[0]);
            chargerDock.setChargeRate(thisDock[1]);
            chargerDockList.add(chargerDock);
        }
        ChargeScheduleService chargeScheduleService = new ChargeScheduleService();
        chargeScheduleService.setChargerDockList(chargerDockList);
        chargeScheduleService.setTruckInfoList(truckInfoList);
        chargeScheduleService.setHours(hours);
        chargeScheduleService.setScheduleModel(ScheduleModelFactory.getScheduleModel("model.BasicScheduleModel"));
        chargeScheduleService.createSchedule();
    }

}

package model;

import model.IScheduleModel;

public class ScheduleModelFactory {
    public static IScheduleModel getScheduleModel(String scheduleModelType) {
        if (scheduleModelType == null) {
            return null;
        }
        if (scheduleModelType.equalsIgnoreCase("model.BasicScheduleModel")) {
            return new BasicScheduleModel();
        } else {
            return new UnKnownScheduleModel();
        }
    }
}

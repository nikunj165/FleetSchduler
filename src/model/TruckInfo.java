package model;

public class TruckInfo {
    public int id;
    public int capacity;

    public int currentChargeLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentChargeLevel() {
        return currentChargeLevel;
    }

    public void setCurrentChargeLevel(int currentChargeLevel) {
        this.currentChargeLevel = currentChargeLevel;
    }

}

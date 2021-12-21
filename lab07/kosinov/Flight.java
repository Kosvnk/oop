package kosinov;

public class Flight {

    private String nameOfStation;
    private String arrivalTime;

    public Flight() {
        this.nameOfStation = null;
        this.arrivalTime = null;
    }
    public Flight(String nofs, String at) {
        this.nameOfStation = nofs;
        this.arrivalTime = at;
    }

    public String getNameOfStation() {
        return nameOfStation;
    }

    public void setNameOfStation(String nameOfStation) {
        this.nameOfStation = nameOfStation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return nameOfStation + " " + arrivalTime;
    }
}

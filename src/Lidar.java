import java.util.ArrayList;

public class Lidar extends Sensor{
    private int Distance_car;
    public ArrayList<Integer> Lidar_data = new ArrayList<>();

    public  Lidar (int obstacle,ArrayList<Integer> data) {
        this.Distance_car=obstacle;
        this.Lidar_data=data;
    }
}

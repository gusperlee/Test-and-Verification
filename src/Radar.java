import java.util.ArrayList;

public class Radar extends Sensor{

    public int distance_obs;
    public ArrayList<Integer> sensor_data ;

    public  Radar (int obstacle,ArrayList<Integer> data) {
        this.distance_obs = obstacle;
        this.sensor_data = data;
    }
}

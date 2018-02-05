import java.util.ArrayList;

public class Lidar {

    private int Distance_car;
    public ArrayList<Integer> Lidar_data = new ArrayList<>();
    public int detect_distance=1;
    public int i=0;
    public  Lidar (int obstacle,ArrayList<Integer> data) {
        this.Distance_car=obstacle;
        this.Lidar_data=data;
    }

    int getDistance_obs(){
        return Distance_car;
    }



    boolean Check_left_lane(int dis_to_target) {

        if (Distance_car > 1) {
            return true;
        }
        return false;
    }
    public ArrayList<Integer> checkReading(int to_obstacle ) {

        //sensor_data=new int [];
        // this.distance_obs=reading;
        if ( to_obstacle < 50  && to_obstacle > 0 && to_obstacle <= detect_distance  ){
            Lidar_data.add(1);
            i++;
        }else if (to_obstacle < 50  && to_obstacle > 0 &&  to_obstacle >detect_distance ){
            Lidar_data.add(2);
            i++;
        } else  {
            Lidar_data.add(-1);
            i++;
        }
        return Lidar_data;

    }
}



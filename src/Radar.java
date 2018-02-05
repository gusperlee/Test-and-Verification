import java.util.ArrayList;

public class Radar {

    public int distance_obs;
    public ArrayList<Integer> sensor_data = new ArrayList<>();
    public int detect_distance=10;
    public int i=0;

    public  Radar (int obstacle,ArrayList<Integer> data) {
        this.distance_obs =obstacle;
        this.sensor_data=data;
    }

   // int getDistance_obs(){
        //return distance_obs;
    //}


    boolean Check_left_lane(int dis_to_target) {

        if (distance_obs > 1) {
            return true;
        }
        return false;
    }

    void setDistance_obs(int obst) {

         this.distance_obs =obst;
    }
    public ArrayList<Integer> checkReading(int reading ) {

        //sensor_data=new int [];
       // this.distance_obs=reading;
        if ( reading < 50  && reading > 0 && reading <= detect_distance  ){
            sensor_data.add(1);
            i++;
        }else if (reading < 50  && reading > 0 &&  reading >detect_distance ){
            sensor_data.add(2);
            i++;
        } else  {
            sensor_data.add(-1);
            i++;
        }
        return sensor_data;

    }


}



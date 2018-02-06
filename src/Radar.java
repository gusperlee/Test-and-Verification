import java.util.ArrayList;

public class Radar {

    public int distance_obs;
    public ArrayList<Integer> sensor_data ;
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
    public int checkReading(int reading ) {

        //sensor_data = new ArrayList<>();

        if ( reading < 50  && reading > 0 && reading <= detect_distance  ){
            return 1;
           // i++;
        }else if (reading < 50  && reading > 0 &&  reading >detect_distance ){
            return 2;
           // i++;
        } else  {
            return -1;
           // i++;
        }


    }


}





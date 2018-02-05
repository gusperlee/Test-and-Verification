public class Radar {

    private int Distance_obs;
    int sensor_data[];

    public  Radar (int obstacle,int data[]) {
        this.Distance_obs=obstacle;
        this.sensor_data=data;
    }

    int getDistance_obs(){
        return Distance_obs;
    }


    boolean Check_left_lane(int dis_to_target) {

        if (Distance_obs > 500) {
            return true;
        }
        return false;
    }

    void setDistance_obs(int obst) {

         this.Distance_obs=obst;
    }
}



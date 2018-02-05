public class Lidar {

    private int Distance_car;
    public int Lidar_data[];


    public  Lidar (int obstacle,int data[]) {
        this.Distance_car=obstacle;
        this.Lidar_data=data;
    }

    int getDistance_obs(){
        return Distance_car;
    }



    boolean Check_left_lane(int dis_to_target) {

        if (Distance_car > 500) {
            return true;
        }
        return false;
    }
}



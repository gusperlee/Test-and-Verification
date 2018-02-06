import java.awt.*;
import java.util.ArrayList;

public class CarClass {

    public int Current_postion = 0;
    public int lane_pos = 1;
    public ArrayList<Integer> data = new ArrayList<>();
   // public int j = 0;
    public boolean isEmpty;
    private Radar front_radar = new Radar(0, new ArrayList<>());
    private Radar rear_radar = new Radar(0, new ArrayList<>());
    private Radar left_radar = new Radar(0, new ArrayList<>());
    private Lidar lidar = new Lidar(0, new ArrayList<>());

    public CarClass(int positionx, int positionY) {
        this.Current_postion = positionx;
        this.lane_pos = positionY;
    }

    // Assuming the car is moving 5 meters whenever the move function is called the car will move 5 meters. it stops  it reaches 100 meters.

    public boolean moveForward() {
        // int wheel_diam =5;
        // int distance=500;
        // int motor_diam;
        // double Spin=500/(2*Math.PI*5);
        if (Current_postion < 100 && Current_postion >= 0) {

            Current_postion += 5;
            return true;
        } else {

            return false;

        }
    }

    public boolean leftLaneDetect (int front, int rear, int left , int lidar_data, int front1, int rear1, int left1 , int lidar_data1 ) {

        int count_change=0;
        int count_faulty=0;
        query(front,rear,left,lidar_data);
        query(front1,rear1,left1,lidar_data1);

        for (int j = 0; j < data.size(); j++) {

            if (data.get(j) == -1) {
                count_faulty++;

            }
            if (data.get(j) == 2) {
                count_change++;

            }

        }
        if (count_change > 4 && count_faulty > 2) {
            isEmpty = false;
        } else {
            isEmpty = true;
        }
        return isEmpty;
    }

    public ArrayList<Integer> query(int front, int rear, int left , int lidar_data) {
       // front_radar.checkReading(front);
        //rear_radar.checkReading(rear);
        //left_radar.checkReading(left);
       // lidar.checkReading(lidar_data);

        data.add(front_radar.checkReading(front));
        data.add(rear_radar.checkReading(rear));
        data.add(left_radar.checkReading(left));
        data.add(lidar.checkReading(lidar_data));

        System.out.println(data.toString());
        // i++;
        // for (int i=0 ; i<8 ; i++) {

        // if (data.get(i) !=0) {
        /// i++;
        // } else {

        //  }
        //  }

        // j++;
        return data;
    }

    public void changeLane() {

        if (isEmpty) {
           moveForward();
           this.lane_pos=+1;
        } else {
            moveForward();
        }
    }

    //checks in which lane the car is
    Point whereIs() {
        return new Point(Current_postion, lane_pos);
    }
}